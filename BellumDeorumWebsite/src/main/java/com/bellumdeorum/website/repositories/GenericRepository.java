package com.bellumdeorum.website.repositories;

import java.util.List;

import com.bellumdeorum.website.models.Model;

public abstract class GenericRepository<T extends Model> {
	protected abstract List<T> getModels();
	
	public T get(long id) {
		for (T t : getModels()) {
			if (t.getId() == id) {
				return t;
			}
		}
		
		return null;
	}
}
