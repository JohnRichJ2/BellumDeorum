package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Empire;
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
	
	public Class<User> tClass() { return User.class; }
	
	@Override
	public User get(long id) {
		if (super.get(id) != null) {
			return super.get(id);
		}

		List<User> users = new ArrayList<User>();
		users.add(Constants.USER_JOHN);
		users.add(Constants.USER_WOLF);
		users.add(Constants.USER_JOE);
		users.add(Constants.USER_BOPH);
		
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	protected List<User> getModels() {
		List<User> users = new ArrayList<User>();
		users.add(get(1L));
		users.add(get(2L));
		users.add(get(3L));
		users.add(get(4L));
		
		return users;
	}
}
