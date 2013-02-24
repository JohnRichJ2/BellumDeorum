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
import org.springframework.web.servlet.ModelAndView;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.services.EmpireService;

@Controller
@RequestMapping(value = "/empire/{empireId}")
public class EmpireController {
	private final EmpireService empireService;
	
	protected EmpireController() {
		this.empireService = null;
	}
	
	@Autowired
	public EmpireController(EmpireService empireService) {
		this.empireService = empireService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView empire(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("empireId") long empireId) {
		
		Empire empire = empireService.getEmpire(empireId);
		model.addAttribute("empire", empire);
		
		return new ModelAndView("base", model);
	}

}
