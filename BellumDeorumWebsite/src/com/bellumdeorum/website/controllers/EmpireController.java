package com.bellumdeorum.website.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.services.EmpireService;
import com.bellumdeorum.website.utils.SessionUtil;

@Controller
@RequestMapping(value = "/empire")
public class EmpireController {
	private final EmpireService empireService;
	private final ObjectMapper mapper;
	
	protected EmpireController() {
		this.empireService = null;
		this.mapper = null;
	}
	
	@Autowired
	public EmpireController(EmpireService empireService, ObjectMapper mapper) {
		this.empireService = empireService;
		this.mapper = mapper;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView empire(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model) {
		Long userId = SessionUtil.getInstance().getUserId(request.getRemoteAddr());
		
		if (userId == null) {
			return new ModelAndView("redirect:/", model);
		}	
		
		Empire empire = empireService.getOrCreateEmpireByUserId(userId);
		model.addAttribute("empire", empire);
		
		try {
			model.addAttribute("jsonEmpire", mapper.writeValueAsString(empire));
		} catch(Exception e) {
			model.addAttribute("jsonEmpire", "yeah, yeah, yeah" + e);
		}
				
		return new ModelAndView("base", model);
	}

	@RequestMapping(value = "/{empireId}", method = RequestMethod.GET)
	public ModelAndView empire(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("empireId") long empireId) {
		
		Empire empire = empireService.getEmpire(empireId);
		model.addAttribute("empire", empire);
		
		try {
			model.addAttribute("jsonEmpire", mapper.writeValueAsString(empire));
		} catch(Exception e) {
			model.addAttribute("jsonEmpire", "yeah, yeah, yeah" + e);
		}
				
		return new ModelAndView("base", model);
	}

}
