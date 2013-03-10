package com.bellumdeorum.userservice.outputs;

import com.bellumdeorum.userservice.UserDetails;

public class GetUserDetailsOutput {
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
