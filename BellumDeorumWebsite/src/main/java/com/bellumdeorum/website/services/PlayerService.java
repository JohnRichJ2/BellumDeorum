package com.bellumdeorum.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Player;
import com.bellumdeorum.website.repositories.PlayerRepository;

@Component
public class PlayerService {
	private final PlayerRepository playerRepo;
	
	@Autowired
	public PlayerService(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}
	
	public Player getPlayer(long id) {
		return playerRepo.get(id);
	}
}
