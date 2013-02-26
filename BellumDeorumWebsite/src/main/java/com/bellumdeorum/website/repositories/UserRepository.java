package com.bellumdeorum.website.repositories;


import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;

@Component
public class UserRepository extends GenericRepository<User> {
		
	public UserRepository() {
		super(User.class);
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		for (User user : getAll()) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
}
