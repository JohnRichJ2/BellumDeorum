package com.bellumdeorum.shared.managers;

import java.util.HashMap;

public class SessionManager {
	private static SessionManager instance = new SessionManager();
	private static HashMap<String, Object> session = new HashMap<String, Object>();
	
	private SessionManager() { }
	
	public static SessionManager getInstance() {
		return instance;
	}
	
	public void put(String key, Object value) {
		session.put(key, value);
	}
		
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) session.get(key);
	}
	
}
