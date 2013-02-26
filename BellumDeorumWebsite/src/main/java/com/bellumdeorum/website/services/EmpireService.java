package com.bellumdeorum.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.repositories.EmpireRepository;
import com.bellumdeorum.website.utils.Constants;

@Component
public class EmpireService {
	private final EmpireRepository empireRepo;

	@Autowired
	public EmpireService(EmpireRepository empireRepo) {
		this.empireRepo = empireRepo;
	}
	
	public Empire createOrUpdateEmpire(long userId, String name) {
		Empire empire = empireRepo.getEmpireByUserId(userId);
		
		if (empire == null) {
			empire = new Empire();
			empire.setUserId(userId);
			empire.setVersion(Constants.EMPIRE_VERSION);
		}
		
		empire.setName(name);
		
		return empireRepo.save(empire);
	}
	
	public Empire getEmpire(long id) {
		return empireRepo.get(id);
	}
	
	public Empire getOrCreateEmpireByUserId(long userId) {
		Empire empire = empireRepo.getEmpireByUserId(userId);
		
		if (empire == null) {
			empire = createOrUpdateEmpire(userId, "DEFAULT_NAME");
		}
		
		return empire;
	}
}
