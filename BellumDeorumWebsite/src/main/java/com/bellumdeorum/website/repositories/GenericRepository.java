package com.bellumdeorum.website.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bellumdeorum.website.models.Model;

@Component
public abstract class GenericRepository<T extends Model> {
	private static final Logger logger = LoggerFactory.getLogger(GenericRepository.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public abstract Class<T> tClass();
			
	public String getPath(String className, long id) {
		return String.format("./simpledb/bellumdeorum/%s/%d.json", className.toLowerCase(), id);
	}
	
	public String getPath(T model) {
		return getPath(model.getClass().getSimpleName(), model.getId());
	}
	
	public T getNextAvailableId(T model) {
		long id = 100L;
		do {
			model.setId(++id);

			if (!(new File(getPath(model)).exists()) && createNewFile(model)) {
				return model;
			}
		} while(true);
	}
	
	public boolean createNewFile(T model) {
		File file = new File(getPath(model));
		try {
			logger.debug(String.format("Creating new file... %s", file));
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			logger.error("Error creating new file..." + file.getAbsolutePath(), e);
			return false;
		}
		
		return true;
	}
		
	public T save(T model) {
		if (model.getId() == null) {
			model = getNextAvailableId(model);
		}
		
		try {
			mapper.writeValue(new File(getPath(model)), model);
		} catch (FileNotFoundException e) {
			// THIS ONLY EXISTS FOR OBJECTS I CREATED BEFORE USING THE JSON SAVE
			if (createNewFile(model)) {
				this.save(model);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return model;
	}
	
	public T get(long id) {
		T model = null;
		try {
			model = (T) mapper.readValue(new File(getPath(tClass().getSimpleName(), id)), tClass());
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
		
		return model;
	}
}
