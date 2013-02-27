package com.bellumdeorum.website.utils;

import com.bellumdeorum.website.models.User;

public class SessionUtil {
	private static SessionUtil instance = new SessionUtil();
	
	private SessionUtil() { }
	
	public static SessionUtil getInstance() {
		return instance;
	}
	
	private static Long userId;
	
	public void logUserIn(User user) {
		userId = user.getId();
	}
	
	public void logUserOut() {
		userId = null;
	}
	
	public Long getUserId() {
		return userId;
	}
}
