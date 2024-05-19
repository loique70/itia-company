package com.itia.sitevitrine.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.itia.sitevitrine.exceptions.GeneralKnowException;
import com.itia.sitevitrine.models.AuthenticationRequest;
import com.itia.sitevitrine.models.AuthenticationResponse;
import com.itia.sitevitrine.models.RegisterRequest;

public interface AuthenticationService {
    public AuthenticationResponse register(RegisterRequest registerRequest) throws GeneralKnowException;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
