package com.bellumdeorum.website.services;

import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Registration;
import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.models.Registration.RegistrationStatus;
import com.bellumdeorum.website.models.User.UserStatus;
import com.bellumdeorum.website.repositories.RegistrationRepository;
import com.bellumdeorum.website.utils.Constants;

@Component
public class RegistrationService {
	private final RegistrationRepository registrationRepo;
	private final UserService userService;

	@Autowired
	public RegistrationService(RegistrationRepository registrationRepo, UserService userService) {
		this.registrationRepo = registrationRepo;
		this.userService = userService;
	}
	
	public boolean registerUser(long userId, String token) {
		Registration registration = getSentRegistrationForUser(userId);
		
		if (registration == null) {
			return false;
		}
		
		User user = userService.getUser(userId);
		if (registration.getToken().equals(token)) {
			String name = null, email = user.getEmail(), password = null;
			user = userService.createOrUpdateUser(name, email, password, UserStatus.REGISTERED);
		}
		
		return ((user != null) && (user.getStatus().equals(UserStatus.REGISTERED)));
	}
	
	public Registration createOrUpdateRegistraion(String name, String email, String password) {
		User user = userService.createOrUpdateUser(name, email, password, null);
		
		Registration registration = getSentRegistrationForUser(user.getId());
		
		if (registration == null) {
			registration = new Registration();
			registration.setStatus(RegistrationStatus.SENT);
			registration.setUser(user);
			registration.setExpirationDate((new DateTime()).plusDays(14));
			registration.setToken(UUID.randomUUID().toString());
		}
		
		registration.setVersion(Constants.REGISTRATION_VERSION);
		registrationRepo.save(registration);
		
		return registration;
	}
	
	public Registration getSentRegistrationForUser(long userId) {
		Registration registration = registrationRepo.getSentRegistrationForUser(userId);
		
		if ((registration != null) && (registration.getExpirationDate().isBeforeNow())) {
			registration.setStatus(RegistrationStatus.EXPIRED);
			registrationRepo.save(registration);
			return null;
		}
		
		return registration;
	}
}
