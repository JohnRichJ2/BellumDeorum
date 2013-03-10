package com.bellumdeorum.website.services;

import org.springframework.stereotype.Component;

import com.bellumdeorum.userservice.UserDetails;
import com.bellumdeorum.userservice.clients.GetUserDetailsClient;
import com.bellumdeorum.userservice.inputs.GetUserDetailsInput;

@Component
public class UserService {
	
	public Object createOrUpdateUser(String name, String email, String password, Object status) {
		return null;
	}
	
	public UserDetails getUser(String email, String password) {
		GetUserDetailsClient client = new GetUserDetailsClient();
		GetUserDetailsInput input = new GetUserDetailsInput();
		input.setEmail(email);
		input.setPassword(password);
		
		return client.call(input).getUserDetails(); 
	}
	
	public UserDetails getUser(long id) {
		GetUserDetailsClient client = new GetUserDetailsClient();
		GetUserDetailsInput input = new GetUserDetailsInput();
		input.setId(id);
		
		return client.call(input).getUserDetails(); 
	}	
}
