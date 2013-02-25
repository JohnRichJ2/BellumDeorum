package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;

@Component
public class UserRepository extends GenericRepository<User> {
		
	public User getUserByEmailAndPassword(String email, String password) {
		for (User user : getModels()) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
	
	public Class<User> tClass() { return User.class; }
	
	protected List<User> getModels() {
		List<User> users = new ArrayList<User>();
		users.add(get(1L));
		users.add(get(2L));
		users.add(get(3L));
		users.add(get(4L));
		
		return users;
	}
}
