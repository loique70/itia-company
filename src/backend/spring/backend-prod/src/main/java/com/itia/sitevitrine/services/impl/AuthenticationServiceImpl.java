package com.itia.sitevitrine.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itia.sitevitrine.beans.Token;
import com.itia.sitevitrine.beans.User;
import com.itia.sitevitrine.configs.security.JwtService;
import com.itia.sitevitrine.exceptions.GeneralKnowException;
import com.itia.sitevitrine.models.AuthenticationRequest;
import com.itia.sitevitrine.models.AuthenticationResponse;
import com.itia.sitevitrine.models.Level;
import com.itia.sitevitrine.models.RegisterRequest;
import com.itia.sitevitrine.models.SpecificErrorCode;
import com.itia.sitevitrine.models.SrcRegionCode;
import com.itia.sitevitrine.models.SystemError;
import com.itia.sitevitrine.models.TokenType;
import com.itia.sitevitrine.repository.TokenRespository;
import com.itia.sitevitrine.repository.UserRepository;
import com.itia.sitevitrine.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    private final UserRepository userRepository;
    private final TokenRespository tokenRespository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) throws GeneralKnowException {
        User optionalUser = userRepository.findByEmail(registerRequest.email())
                .orElse(null);

        if (optionalUser != null) {
            SystemError systemError = new SystemError(SrcRegionCode.AUTH, SpecificErrorCode.USER_ALREADY_EXIST);
            throw new GeneralKnowException(systemError, logger, Level.WARN,
                    "Email [%s] is already taken".formatted(registerRequest.email()),
                    HttpStatus.BAD_REQUEST);
        }

        User user = User
                .builder()
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .roles(registerRequest.roles())
                .build();
        user.setRoles(registerRequest.roles());
        User savedUser = userRepository.save(user);

        // Tokens generation
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        saveUserToken(savedUser, jwtToken);

        return new AuthenticationResponse(jwtToken, refreshToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.email(),
                        authenticationRequest.password()));

        User user = userRepository.findByEmail(authenticationRequest.email())
                .orElseThrow(() -> new IllegalStateException(
                        "User with email [%s] not found".formatted(authenticationRequest.email())));

        // Tokens generation
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        revokeAllUserTokens(user);

        saveUserToken(user, jwtToken);

        return new AuthenticationResponse(jwtToken, refreshToken);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRespository.findAllValidTokensByUserId(user.getId());

        if (validUserTokens.isEmpty())
            return;

        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        tokenRespository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token
                .builder()
                .expired(false)
                .revoked(false)
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .build();

        tokenRespository.save(token);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return;

        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(refreshToken);

        if (userEmail != null) {
            User user = userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new IllegalStateException("User not found"));

            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);

                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);

                AuthenticationResponse authenticationResponse = new AuthenticationResponse(
                        accessToken,
                        refreshToken);

                new ObjectMapper().writeValue(response.getOutputStream(), authenticationResponse);
            }
        }
    }
}
