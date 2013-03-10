package com.bellumdeorum.userservice.models;

import com.bellumdeorum.shared.model.AbstractModel;

public class User implements AbstractModel {
	public enum UserStatus {
		UNREGISTERED, REGISTERED, BANNED
	}
	
	private Long id;
	private Long version;
	
	private String name;
	private String email;
	private String password;
	private UserStatus status;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
}

