package com.bellumdeorum.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.repositories.UserRepository;

@Component
public class UserService {
	private final UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User getUser(String email, String password) {
		return userRepo.getUserByEmailAndPassword(email, password);
	}
	
	public User getUser(long id) {
		return userRepo.get(id);
	}	
}
