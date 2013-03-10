package com.bellumdeorum.website.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bellumdeorum.shared.utilities.AbstractClient;
import com.bellumdeorum.userservice.User;

@Controller
public class HomeController {
	
	private final ObjectMapper mapper;
	
	protected HomeController() {
		this.mapper = null;
	}
	
	@Autowired
	public HomeController(ObjectMapper mapper) {
		this.mapper = mapper;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getHeader("user-agent"));
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		RestTemplate restTemplate = new RestTemplate();
		User user = new User();
		user.setName("John");
		
		User response = new User();
		try {
			System.out.println(String.format("http://localhost:8080/userservice/user/%s", mapper.writeValueAsString(user)));
			//response = (User)restTemplate.getForObject("http://localhost:8080/userservice/user/{user}", User.class, mapper.writeValueAsString(user));
			response = (User)restTemplate.postForObject("http://localhost:8080/userservice/user/{json}", null, User.class, mapper.writeValueAsString(user));
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserServiceClient client = new UserServiceClient();
		response = client.post(user);
		
		System.out.println(response.getName().toString());
		
		return "home";
		
	}
	
	public class UserServiceClient extends AbstractClient<User> {
		public UserServiceClient() {
			super(User.class, "http://localhost:8080/userservice", "user");
		}
	}
	
}
