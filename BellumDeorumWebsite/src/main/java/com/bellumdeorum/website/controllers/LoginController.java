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

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.services.EmpireService;
import com.bellumdeorum.website.services.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private final UserService userService;
	private final EmpireService empireService;
	
	protected LoginController() {
		this.userService = null;
		this.empireService = null;
	}
	
	@Autowired
	public LoginController(UserService userService, EmpireService empireService) {
		this.userService = userService;
		this.empireService = empireService;
	}	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		return new ModelAndView("login_module", model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(Locale locale, ModelMap model,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.getUser(email, password);
		
		if (user == null) {
			return new ModelAndView("login", model);
		}
		
		Empire empire = empireService.getEmpireByUserId(user.getId());
		
		return new ModelAndView("redirect:/empire/" + empire.getId(), model);
	}
}
