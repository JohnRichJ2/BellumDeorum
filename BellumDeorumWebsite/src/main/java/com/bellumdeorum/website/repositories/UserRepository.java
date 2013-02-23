package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;

@Component
public class UserRepository extends GenericRepository<User> {
	public UserRepository() { }
	
	public User getUserByEmailAndPassword(String email, String password) {
		for (User user : getUsers()) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
	
	private static final List<User> getUsers() {
		User john = new User(1L, "john", "john@gmail.com", "pass");
		User wolf = new User(2L, "wolf", "wolf@gmail.com", "pass");
		User joe = new User(3L, "joe", "joe@gmail.com", "claudio");
		User boph = new User(4L, "boph", "boph@gmail.com", "ilikepenis");
		
		List<User> users = new ArrayList<User>();
		users.add(john);
		users.add(wolf);
		users.add(joe);
		users.add(boph);
		
		return users;
	}
}
