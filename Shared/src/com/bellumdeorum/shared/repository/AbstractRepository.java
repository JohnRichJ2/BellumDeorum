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
	private final List<T> initModels;
	
	public AbstractRepository(Class<T> modelClass) {
		db = new DBManager<T>(modelClass);
		initModels = null;
	}
	
	public AbstractRepository(Class<T> modelClass, List<T> initModels) {
		db = new DBManager<T>(modelClass);
		this.initModels = initModels;
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
		T model = db.select(id);
		
		if (requiresInitialization(model)) {
			logger.info("Model is out of date, updating model.");
			for (T t : initModels) {
				if (t.getId() == id) {
					return save(t);
				}
			}
		}
		
		return model;
	}

	public List<T> get() {
		List<T> modelList = db.select();
		
		if (requiresInitialization(modelList)) {
			logger.info("Models are out of date, updating modelList.");
			return save(initModels);
		}
		
		return modelList;
	}
	
	private boolean requiresInitialization(T model) {
		if (initModels == null) {
			return false;
		} else if (initModels.size() == 0) {
			return false;
		} else if (initModels.get(0) == null) {
			return false;
		} else if (model == null) {
			return true;
		} else if (model.getVersion() == null) {
			return true;
		} else if (model.getVersion() < initModels.get(0).getVersion()) {
			return true;
		}
		
		return false;
	}
	
	private boolean requiresInitialization(List<T> modelList) {
		if (initModels == null) {
			return false;
		} else if (initModels.size() == 0) {
			return false;
		} else if (initModels.get(0) == null) {
			return false;
		} else if (modelList == null) {
			return true;
		} else if (modelList.size() < initModels.size()) {
			return true;
		}
		
		return false;
	}
}
