package com.itia.sitevitrine.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itia.sitevitrine.exceptions.GeneralKnowException;
import com.itia.sitevitrine.models.AuthenticationRequest;
import com.itia.sitevitrine.models.AuthenticationResponse;
import com.itia.sitevitrine.models.RegisterRequest;
import com.itia.sitevitrine.services.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest)
            throws GeneralKnowException {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @PostMapping("refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }
}
