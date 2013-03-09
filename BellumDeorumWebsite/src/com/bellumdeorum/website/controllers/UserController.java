package com.bellumdeorum.website.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bellumdeorum.website.models.User;
import com.bellumdeorum.website.services.UserService;
import com.bellumdeorum.website.utils.SessionUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	private final UserService userService;
	private final ObjectMapper mapper;
	
	protected UserController() {
		this.userService = null;
		this.mapper = null;
	}
	
	@Autowired
	public UserController(UserService userService, ObjectMapper mapper) {
		this.userService = userService;
		this.mapper = mapper;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView empire(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		Long userId = SessionUtil.getInstance().getUserId();
		
		if (userId == null) {
			return new ModelAndView("redirect:/", model);
		}
		
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		
		try {
			model.addAttribute("jsonUser", mapper.writeValueAsString(user));
		} catch(Exception e) {
			model.addAttribute("jsonEmpire", "yeah, yeah, yeah" + e);
		}
				
		return new ModelAndView("user", model);
	}
}
