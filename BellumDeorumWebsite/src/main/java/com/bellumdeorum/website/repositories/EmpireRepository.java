package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.utils.Constants;

@Component
public class EmpireRepository extends GenericRepository<Empire> {
	
	public Empire getEmpireByUserId(long userId) {
		for (Empire empire : getModels()) {
			if (empire.getUser().getId() == userId) {
				return empire;
			}
		}
		
		return null;
	}
	
	
	protected List<Empire> getModels() {
		List<Empire> empires = new ArrayList<Empire>();
		empires.add(Constants.EMPIRE_JOHN);
		empires.add(Constants.EMPIRE_WOLF);
		empires.add(Constants.EMPIRE_JOE);
		empires.add(Constants.EMPIRE_BOPH);

		return empires;
	}
}
