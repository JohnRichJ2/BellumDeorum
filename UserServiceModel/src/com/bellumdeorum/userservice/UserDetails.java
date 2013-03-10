package com.bellumdeorum.userservice;

public class UserDetails {
	public enum UserStatus {
		UNREGISTERED, REGISTERED, BANNED
	}
	
	private Long id;
	private String name;
	private String email;
	private UserStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
}
