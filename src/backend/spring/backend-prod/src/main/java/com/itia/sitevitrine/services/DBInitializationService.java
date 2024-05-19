package com.itia.sitevitrine.services;

import com.itia.sitevitrine.exceptions.GeneralKnowException;

public interface DBInitializationService {
	public void initUsers(AuthenticationService authenticationService) throws GeneralKnowException;
}
