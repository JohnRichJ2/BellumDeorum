package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.utils.Constants;

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
	
	protected List<User> getModels() {
		List<User> users = new ArrayList<User>();
		users.add(Constants.USER_JOHN);
		users.add(Constants.USER_WOLF);
		users.add(Constants.USER_JOE);
		users.add(Constants.USER_BOPH);
		
		return users;
	}
}
