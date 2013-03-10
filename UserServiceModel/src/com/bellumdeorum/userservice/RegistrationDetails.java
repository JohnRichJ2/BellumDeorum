package com.bellumdeorum.userservice;

import org.joda.time.DateTime;

public class RegistrationDetails {
	public enum RegistrationStatus {
		SENT, USED, CANCELLED, EXPIRED
	}
	
	private Long id;
	
	private Long userId;
	private String token;
	private RegistrationStatus status;
	private DateTime expirationDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public RegistrationStatus getStatus() {
		return status;
	}
	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}
	public DateTime getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
}
