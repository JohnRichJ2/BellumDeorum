package com.bellumdeorum.website.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Locale locale, ModelMap model) {
		return new ModelAndView("login_module", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(Locale locale, ModelMap model,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		return new ModelAndView("home", model);
	}
}
