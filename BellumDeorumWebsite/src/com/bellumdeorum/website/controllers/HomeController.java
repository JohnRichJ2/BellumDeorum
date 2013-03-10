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
import com.bellumdeorum.userservice.UserDetails;
import com.bellumdeorum.userservice.clients.GetUserDetailsClient;
import com.bellumdeorum.userservice.inputs.GetUserDetailsInput;

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
		
		GetUserDetailsClient client = new GetUserDetailsClient();
		GetUserDetailsInput input = new GetUserDetailsInput();
		input.setId(1L);
		UserDetails response = client.call(input).getUserDetails();
		
		System.out.println(response.getName().toString());
		
		return "home";
		
	}
}
