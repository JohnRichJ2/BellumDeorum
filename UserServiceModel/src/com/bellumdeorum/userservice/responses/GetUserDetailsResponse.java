package com.bellumdeorum.userservice.responses;

import com.bellumdeorum.userservice.UserDetails;

public class GetUserDetailsResponse {
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
