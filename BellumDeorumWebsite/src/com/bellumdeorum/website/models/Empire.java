package com.bellumdeorum.website.models;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Empire implements Model {
	private Long id;
	private Long version;
	
	private Long userId;
	private String name;

	@JsonIgnore
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		setUserId(user.getId());
		this.user = user;
	}
}
