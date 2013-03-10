package com.bellumdeorum.userservice.activity;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bellumdeorum.shared.utilities.AbstractService;
import com.bellumdeorum.userservice.UserDetails;
import com.bellumdeorum.userservice.inputs.GetUserDetailsInput;
import com.bellumdeorum.userservice.outputs.GetUserDetailsOutput;

@Controller
public class GetUserDetailsActivity extends AbstractService<GetUserDetailsInput, GetUserDetailsOutput> {
	
	public GetUserDetailsActivity() {
		super(GetUserDetailsInput.class);
	}
	
	@RequestMapping(value = "/getuserdetails/{json}", method = RequestMethod.GET)
	@ResponseBody
	public GetUserDetailsOutput enact(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("json") String json) {
		
		GetUserDetailsInput input = requestValue(json);
		if (input != null) {
			System.out.println(input.getId());
		}
		
		UserDetails user = new UserDetails();
		user.setName("JohnYEah");
		
		GetUserDetailsOutput output = new GetUserDetailsOutput();
		output.setUserDetails(user);
		
		return output;
	}
}
