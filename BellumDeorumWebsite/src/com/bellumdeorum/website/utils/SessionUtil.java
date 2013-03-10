package com.bellumdeorum.website.utils;

import com.bellumdeorum.website.models.User;

import com.bellumdeorum.shared.managers.SessionManager;

public class SessionUtil {
	private static SessionUtil instance = new SessionUtil();
	private static SessionManager session = SessionManager.getInstance();
	
	private SessionUtil() { }
	
	public static SessionUtil getInstance() {
		return instance;
	}
	
	public void logUserIn(String ip, User user) {
		session.put(ip, "USER_ID", user.getId());
	}
	
	public void logUserOut(String ip) {
		session.put(ip, "USER_ID", null);
	}
	
	public Long getUserId(String ip) {
		return session.get(ip, "USER_ID");
	}
}
