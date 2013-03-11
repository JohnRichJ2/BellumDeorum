package com.bellumdeorum.userservice.clients;

import com.bellumdeorum.shared.utilities.AbstractClient;
import com.bellumdeorum.userservice.UserServiceClient;
import com.bellumdeorum.userservice.inputs.GetUserDetailsInput;
import com.bellumdeorum.userservice.outputs.GetUserDetailsOutput;

public class GetUserDetailsClient extends AbstractClient<GetUserDetailsInput, GetUserDetailsOutput> implements UserServiceClient {
	public GetUserDetailsClient() {
		super(GetUserDetailsOutput.class, serviceEndpoint, getUserDetails);
	}
	
	public GetUserDetailsOutput call(GetUserDetailsInput request) {
		return get(request);
	}
}
