package com.bellumdeorum.userservice.inputs;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserDetailsInput {
	private Long id;
	
	private String email;
	private String password;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	@JsonIgnore
	public boolean isValid() {
		if (id != null) {
			return true;
		} else if ((email != null) && (password != null)) {
			return true;
		}
		
		return false;
	}

}
