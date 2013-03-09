package com.bellumdeorum.website.repositories;


import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Empire;

@Component
public class EmpireRepository extends GenericRepository<Empire> {
	
	public EmpireRepository() {
		super(Empire.class);
	}
	
	public Empire getEmpireByUserId(long userId) {
		for (Empire empire : getAll()) {
			if (empire.getUserId() == userId) {
				return empire;
			}
		}
		
		return null;
	}
}
