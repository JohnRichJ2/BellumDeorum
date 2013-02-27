package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import com.bellumdeorum.website.models.Registration;
import com.bellumdeorum.website.models.Registration.RegistrationStatus;

public class RegistrationRepository extends GenericRepository<Registration> {
	public RegistrationRepository() {
		super(Registration.class);
	}
	
	public Registration getSentRegistraionForUser(long userId) {
		List<Registration> registrationList = getRegistrationListForUserByStatus(userId, RegistrationStatus.SENT);
		
		if (registrationList.size() == 0) {
			return null;
		} else if (registrationList.size() != 1) {
			// ERROR?
		}

		return registrationList.get(0);
	}
	
	public List<Registration> getRegistrationListForUserByStatus(long userId, RegistrationStatus status) {
		List<Registration> registrationList = new ArrayList<Registration>();
		
		for (Registration registration : getRegistrationListForUser(userId)) {
			if (registration.getStatus().equals(status)) {
				registrationList.add(registration);
			}
		}
		
		return registrationList;
	}
	
	public List<Registration> getRegistrationListForUser(long userId) {
		List<Registration> registrationList = new ArrayList<Registration>();
		
		for (Registration registration : getAll()) {
			if (registration.getUserId() == userId) {
				registrationList.add(registration);
			}
		}
		
		return registrationList;
	}
}
