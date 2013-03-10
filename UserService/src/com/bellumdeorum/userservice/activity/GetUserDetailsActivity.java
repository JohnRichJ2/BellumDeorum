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
import com.bellumdeorum.userservice.User;

@Controller
public class GetUserDetailsActivity extends AbstractService<User, User> {
	
	public GetUserDetailsActivity() {
		super(User.class);
	}
	
	@RequestMapping(value = "/getuserdetails/{json}", method = RequestMethod.GET)
	@ResponseBody
	public User enact(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("json") String json) {
		
		System.out.println(request);
		System.out.println(request.getParameterMap());
		
		System.out.println(json);
		System.out.println("made it here!!!");
		
		User user = requestValue(json);
		if (user != null) {
			System.out.println(user.getName());
			return user;
		}
		
		user = new User();
		user.setName("JohnYEah");
		
		return user;
	}
}
