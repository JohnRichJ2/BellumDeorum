package com.bellumdeorum.website.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.repositories.EmpireRepository;

@Component
public class EmpireService {
	private final EmpireRepository empireRepo;

	@Autowired
	public EmpireService(EmpireRepository empireRepo) {
		this.empireRepo = empireRepo;
	}
	
	public Empire createEmpire(long id) {
		return empireRepo.save(empireRepo.get(id));
	}
	
	public Empire getEmpire(long id) {
		return empireRepo.get(id);
	}
	
	public Empire getEmpireByUserId(long userId) {
		return empireRepo.getEmpireByUserId(userId);
	}
}
