package com.bellumdeorum.website.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bellumdeorum.website.services.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	private final UserService userService;
	
	protected RegisterController() {
		this.userService = null;
	}
	
	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		return new ModelAndView("register", model);
	}
	
	@RequestMapping(value = "/{token}", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("token") String token) {
		
		return null;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView newRegistration(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
		
		userService.createOrUpdateUser(name, email, password);
		
		return new ModelAndView("redirect:/", model);
	}
}
