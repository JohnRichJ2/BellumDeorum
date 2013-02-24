package com.bellumdeorum.website.models;

public class Empire implements Model {
	private long id;
	private User user;
	private String name;
	
	public Empire(long id, User user, String name) {
		this.id = id;
		this.user = user;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
