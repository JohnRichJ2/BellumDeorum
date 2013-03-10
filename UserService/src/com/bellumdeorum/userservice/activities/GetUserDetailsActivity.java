package com.bellumdeorum.userservice.activities;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bellumdeorum.shared.utilities.AbstractService;
import com.bellumdeorum.userservice.UserDetails;
import com.bellumdeorum.userservice.inputs.GetUserDetailsInput;
import com.bellumdeorum.userservice.models.User;
import com.bellumdeorum.userservice.outputs.GetUserDetailsOutput;
import com.bellumdeorum.userservice.services.UserService;

@Controller
public class GetUserDetailsActivity extends AbstractService<GetUserDetailsInput, GetUserDetailsOutput> {
	private final UserService service;
	
	public GetUserDetailsActivity() {
		super(GetUserDetailsInput.class);
		this.service = null;
	}

	@Autowired
	public GetUserDetailsActivity(UserService service) {
		super(GetUserDetailsInput.class);
		this.service = service;
	}
	
	@RequestMapping(value = "/getuserdetails/{json}", method = RequestMethod.GET)
	@ResponseBody
	public GetUserDetailsOutput enact(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("json") String json) {
		GetUserDetailsInput input = requestValue(json);

		User user = null;
		
		if (input.getId() != null) {
			user = service.getUser(input.getId());
		} else {
			user = service.getUser(input.getEmail(), input.getPassword());
		}
		
		if (user != null) {
			GetUserDetailsOutput output = new GetUserDetailsOutput();
			UserDetails userDetails = new UserDetails();
			userDetails.setId(user.getId());
			userDetails.setName(user.getName());
			userDetails.setEmail(user.getEmail());
			userDetails.setStatus(UserDetails.UserStatus.valueOf(user.getStatus().toString()));
			output.setUserDetails(userDetails);

			response.setStatus(HttpServletResponse.SC_OK);
			return output;
		}
		
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return null;
	}
}
