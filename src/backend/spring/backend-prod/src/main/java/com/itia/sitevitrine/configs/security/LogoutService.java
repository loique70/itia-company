package com.itia.sitevitrine.configs.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.itia.sitevitrine.beans.Token;
import com.itia.sitevitrine.repository.TokenRespository;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRespository tokenRespository;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return;

        jwt = authHeader.substring(7);

        Token token = tokenRespository.findByToken(jwt).orElse(null);

        if (token != null) {
            token.setRevoked(true);
            token.setExpired(true);
            tokenRespository.save(token);
        }
    }
}
