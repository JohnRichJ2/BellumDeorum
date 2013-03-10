package com.bellumdeorum.shared.managers;

import java.util.HashMap;

public class SessionManager {
	private static SessionManager instance = new SessionManager();
	private static HashMap<String, HashMap<String, Object>> session = new HashMap<String, HashMap<String, Object>>();
	
	private SessionManager() { }
	
	public static SessionManager getInstance() {
		return instance;
	}
	
	public void put(String ip, String key, Object value) {
		getUserSession(ip).put(key, value);
	}
		
	@SuppressWarnings("unchecked")
	public <T> T get(String ip, String key) {
		return (T) getUserSession(ip).get(key);
	}

	private HashMap<String, Object> getUserSession(String ip) {
		HashMap<String, Object> userSession = session.get(ip);
		if (userSession == null) {
			userSession = new HashMap<String, Object>();
			session.put(ip,  userSession);
		}
		
		return userSession;
	}
}
