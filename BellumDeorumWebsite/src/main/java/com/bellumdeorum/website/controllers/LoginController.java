package com.bellumdeorum.website.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.services.UserService;

@Controller
public class LoginController {
	private final UserService userService;
	
	protected LoginController() {
		this.userService = null;
	}
	
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		return new ModelAndView("login_module", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Locale locale, ModelMap model,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.getUser(email, password);
		
		if (user == null) {
			return new ModelAndView("login", model);
		}
		
		return new ModelAndView("home", model);
	}
}
