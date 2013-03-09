package com.bellumdeorum.website.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;

import com.bellumdeorum.shared.model.AbstractModel;

public class Registration implements AbstractModel {
	public enum RegistrationStatus {
		SENT, USED, CANCELLED, EXPIRED
	}
	
	private Long id;
	private Long version;
	
	private Long userId;
	private String token;
	private RegistrationStatus status;
	private DateTime expirationDate;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		setUserId(user.getId());
		this.user = user;
	}

}
