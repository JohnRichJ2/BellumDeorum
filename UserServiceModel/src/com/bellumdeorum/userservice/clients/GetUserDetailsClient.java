package com.bellumdeorum.userservice.clients;

import com.bellumdeorum.shared.utilities.AbstractClient;
import com.bellumdeorum.userservice.UserServiceClient;
import com.bellumdeorum.userservice.requests.GetUserDetailsRequest;
import com.bellumdeorum.userservice.responses.GetUserDetailsResponse;

public class GetUserDetailsClient extends AbstractClient<GetUserDetailsResponse> implements UserServiceClient {
	protected GetUserDetailsClient() {
		super(GetUserDetailsResponse.class, serviceEndpoint, getUserDetails);
	}
	
	public GetUserDetailsResponse call(GetUserDetailsRequest request) {
		return get(request);
	}
}
