package com.bellumdeorum.shared.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bellumdeorum.shared.managers.DBManager;
import com.bellumdeorum.shared.model.AbstractModel;

@Component
public abstract class AbstractRepository <T extends AbstractModel> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractRepository.class);
	
	private final DBManager<T> db;
	
	public AbstractRepository(Class<T> modelClass) {
		db = new DBManager<T>(modelClass);
	}
	
	public T save(T model) {
		if (model.getId() == null) {
			db.insert(model);
		} else {
			db.save(model);
		}
		
		return model;
	}
	
	public List<T> save(List<T> modelList) {
		for (T model : modelList) {
			save(model);
		}
		return modelList;
	}
	
	public T get(long id) {
		return db.select(id);
	}

	public List<T> get() {
		return db.select();
	}
}
