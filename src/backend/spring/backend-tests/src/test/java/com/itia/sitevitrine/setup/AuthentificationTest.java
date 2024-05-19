package com.itia.sitevitrine.setup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.itia.sitevitrine.sitevitrineApplication;
import com.itia.sitevitrine.models.AuthenticationRequest;
import com.itia.sitevitrine.models.AuthenticationResponse;

@SpringBootTest(classes = sitevitrineApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@ActiveProfiles("test")
public class AuthentificationTest {

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected AuthenticationManager authenticationManager;

    @AfterEach
    public void after() {
        clearSecurityContext();
    }

    @Test
    public void authenticateAsAdmin() {
        authenticateUser("admin@test.com", "password");
    }

    @Test
    public void authenticateAsAnonimous() {
        AuthenticationRequest userLoginDTO = new AuthenticationRequest("anonimous@test.com", "password");

        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/auth/authenticate", userLoginDTO, AuthenticationResponse.class);
        AuthenticationResponse jwtResponse = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        Assertions.assertNotNull(jwtResponse);
        Assertions.assertNull(jwtResponse.accessToken());
        Assertions.assertNull(jwtResponse.refreshToken());
    }

    protected void authenticateUser(String username, String password) {
        AuthenticationRequest userLoginDTO = new AuthenticationRequest(username, password);

        ResponseEntity<AuthenticationResponse> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/auth/authenticate", userLoginDTO, AuthenticationResponse.class);
        AuthenticationResponse jwtResponse = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertNotNull(jwtResponse);
        Assertions.assertNotNull(jwtResponse.accessToken());
        Assertions.assertNotNull(jwtResponse.refreshToken());
    }

    protected void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }
}
