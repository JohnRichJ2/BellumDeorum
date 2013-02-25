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
	
	public Class<Empire> tClass() { return Empire.class; }
	
	@Override
	public Empire get(long id) {
		if (super.get(id) != null) {
			return super.get(id);
		}

		List<Empire> empires = new ArrayList<Empire>();
		empires.add(Constants.EMPIRE_JOHN);
		empires.add(Constants.EMPIRE_WOLF);
		empires.add(Constants.EMPIRE_JOE);
		empires.add(Constants.EMPIRE_BOPH);
		
		for (Empire empire : empires) {
			if (empire.getId() == id) {
				return empire;
			}
		}
		
		return null;
	}
	
	protected List<Empire> getModels() {
		List<Empire> empires = new ArrayList<Empire>();
		empires.add(get(100L));
		empires.add(get(101L));
		empires.add(get(102L));
		empires.add(get(103L));

		return empires;
	}
}
