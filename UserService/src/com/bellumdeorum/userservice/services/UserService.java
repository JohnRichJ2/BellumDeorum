package com.bellumdeorum.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.userservice.models.User;
import com.bellumdeorum.userservice.models.User.UserStatus;
import com.bellumdeorum.userservice.repositories.UserRepository;

@Component
public class UserService {
	private final UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
			
	public User createOrUpdateUser(String name, String email, String password, UserStatus status) {
		User user = userRepo.getUserByEmail(email);
		
		if (user == null) {
			user = new User();
			user.setEmail(email);
			user.setStatus(UserStatus.UNREGISTERED);
			user.setName(name);
			user.setPassword(password);
		} else {
			if (name != null) {
				user.setName(name);
			}
			
			if (password != null) {
				user.setPassword(password);
			}
			
			if (status != null) {
				user.setStatus(status);
			}
		}

		//user.setVersion(Constants.USER_VERSION);
		
		return userRepo.save(user);
	}
	
	public User getUser(String email, String password) {
		return userRepo.getUserByEmailAndPassword(email, password);
	}
	
	public User getUser(long id) {
		return userRepo.get(id);
	}
}
