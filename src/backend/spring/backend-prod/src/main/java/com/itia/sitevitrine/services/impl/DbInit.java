package com.itia.sitevitrine.services.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.itia.sitevitrine.exceptions.GeneralKnowException;
import com.itia.sitevitrine.services.AuthenticationService;
import com.itia.sitevitrine.services.DBInitializationService;

@Service
public class DbInit {
    private DBInitializationService dbInitService;

    public DbInit(DBInitializationService dbInitService) {
        this.dbInitService = dbInitService;
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authenticationService) {
        return args -> {
            try {
                dbInitService.initUsers(authenticationService);
            } catch (GeneralKnowException e) {
            }
        };
    }
}
