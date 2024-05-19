package com.itia.sitevitrine.services.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itia.sitevitrine.exceptions.GeneralKnowException;
import com.itia.sitevitrine.models.AuthenticationResponse;
import com.itia.sitevitrine.models.RegisterRequest;
import com.itia.sitevitrine.models.Role;
import com.itia.sitevitrine.services.AuthenticationService;
import com.itia.sitevitrine.services.DBInitializationService;

@Service
public class DBInitializationServiceImpl implements DBInitializationService {
	private static final Logger logger = LoggerFactory.getLogger(DBInitializationServiceImpl.class);

	@Override
	public void initUsers(AuthenticationService authenticationService) throws GeneralKnowException {
		RegisterRequest admin = new RegisterRequest(
				"Admin",
				"Admin",
				"admin@test.com",
				"password",
				Arrays.asList(Role.ADMIN));
		AuthenticationResponse authenticationResponseAdmin = authenticationService.register(admin);
		if (authenticationResponseAdmin != null)
			logger.info("Admin token: {}", authenticationResponseAdmin.accessToken());
		else
			logger.error("Unable to authenticate default admin: {} {}", admin.firstName() + admin.lastName(),
					admin.email());
	}

}
