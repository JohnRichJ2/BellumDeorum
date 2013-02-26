package com.bellumdeorum.website.repositories;


import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;

@Component
public class UserRepository extends GenericRepository<User> {
		
	public UserRepository() {
		super(User.class);
	}
	
	public User getUserByEmail(String email) {
		for (User user : getAll()) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		
		return null;
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user = getUserByEmail(email);
		
		if ((user != null) && (user.getPassword().equals(password))) {
			return user;
		}
		
		return null;
	}
}
