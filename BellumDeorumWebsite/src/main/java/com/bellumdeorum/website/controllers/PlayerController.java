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

import com.bellumdeorum.website.models.Player;
import com.bellumdeorum.website.services.PlayerService;

@Controller
@RequestMapping("/player/{playerId}")
public class PlayerController {
	private final PlayerService playerService;
	
	protected PlayerController() {
		this.playerService = null;
	}
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Locale locale, ModelMap model,
			@PathVariable("playerId") long playerId) {
		Player player = playerService.getPlayer(playerId);
		
		model.addAttribute("player", player);
		
		return new ModelAndView("base", model);
	}
}
