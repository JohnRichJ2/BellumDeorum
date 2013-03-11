package com.bellumdeorum.website.services;

import org.springframework.stereotype.Component;

@Component
public class RegistrationService {
	
	public boolean registerUser(long userId, String token) {
		return false;
	}
	
	public Object createOrUpdateRegistration(String name, String email, String password) {
		return null;
	}
	
	public Object getSentRegistrationForUser(long userId) {
		return null;
	}
}
