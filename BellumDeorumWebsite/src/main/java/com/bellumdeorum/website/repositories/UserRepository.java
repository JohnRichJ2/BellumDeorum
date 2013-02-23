package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.User;

@Component
public class UserRepository extends GenericRepository<User> {
	private final PlayerRepository playerRepo;
	
	public UserRepository() {
		playerRepo = new PlayerRepository();
	}
	
	public User getUserByEmailAndPassword(String email, String password) {
		for (User user : getModels()) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
	
	protected List<User> getModels() {
		User john = new User(1L, "john", "john@gmail.com", "pass", playerRepo.get(1L));
		User wolf = new User(2L, "wolf", "wolf@gmail.com", "pass", playerRepo.get(2L));
		User joe = new User(3L, "joe", "joe@gmail.com", "claudio", playerRepo.get(3L));
		User boph = new User(4L, "boph", "boph@gmail.com", "ilikepenis", playerRepo.get(4L));
		
		List<User> users = new ArrayList<User>();
		users.add(john);
		users.add(wolf);
		users.add(joe);
		users.add(boph);
		
		return users;
	}
}
