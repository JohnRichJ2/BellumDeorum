package com.bellumdeorum.website.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Model;
import com.bellumdeorum.website.utils.Constants;
import com.bellumdeorum.website.utils.FileUtil;

@Component
public abstract class GenericRepository<T extends Model> {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private final Class<T> modelClass;
	
	public GenericRepository(Class<T> modelClass) {
		this.modelClass = modelClass;
	}
		
	public T save(T model) {
		if (model.getId() == null) {
			model.setId(FileUtil.getInstance().getNextAvailableId(modelClass.getSimpleName()));
		}

		try {
			mapper.writeValue(FileUtil.getInstance().getFile(modelClass.getSimpleName(), model.getId()), model);
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		T model = null;
		try {
			model = (T) mapper.readValue(FileUtil.getInstance().getFile(modelClass.getSimpleName(), id), modelClass);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// THESE LINES ONLY PUT IN SINCE THE MODELS CHANGE 'FREQUENTLY' AND ARE NOT IN GIT
		if ((model == null) || (model.getVersion() == null) || (model.getVersion() < Constants.getVersion(modelClass))) {
			@SuppressWarnings("unchecked")
			List<T> modelList = Constants.getModels(modelClass);
			for (T t : modelList) {
				if (t.getId() == id) {
					save(modelList);
				}
			}
		}
		
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> modelList = new ArrayList<T>();
		
		for (Long id : FileUtil.getInstance().getPaths(modelClass.getSimpleName()).keySet()) {
			modelList.add(get(id));
		}
		
		// THESE LINES ONLY PUT IN SINCE THE MODELS CHANGE 'FREQUENTLY' AND ARE NOT IN GIT, COULD CAUSE INFINITE LOOP
		if (modelList.size() == 0) {
			if (Constants.getModels(modelClass) != null) {
				save(Constants.getModels(modelClass));
				return getAll();
			}
		}
		
		return modelList;
	}
}
