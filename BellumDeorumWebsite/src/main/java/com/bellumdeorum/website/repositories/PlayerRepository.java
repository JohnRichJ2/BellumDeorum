package com.bellumdeorum.website.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Player;

@Component
public class PlayerRepository extends GenericRepository<Player> {
		
	protected List<Player> getModels() {
		Player john = new Player(1L, "J2's World");
		Player wolf = new Player(2L, "Wolf's Place");
		Player joe = new Player(3L, "CLAUDIO IS GOD");
		Player boph = new Player(4L, "ALL QQ NO PEWPEW");
		
		List<Player> users = new ArrayList<Player>();
		users.add(john);
		users.add(wolf);
		users.add(joe);
		users.add(boph);
		
		return users;
	}
}
