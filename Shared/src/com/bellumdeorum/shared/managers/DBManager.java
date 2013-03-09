package com.bellumdeorum.shared.managers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bellumdeorum.shared.model.AbstractModel;

public class DBManager <T extends AbstractModel> {
	private static final Logger logger = LoggerFactory.getLogger(DBManager.class);
	
	private static final FileManager fileManager = FileManager.getInstance();
	private static final ObjectMapper mapper = new ObjectMapper();

	private final Class<T> recordClass;
	private final String table;
	
	public DBManager(Class<T> recordClass) {
		this.recordClass = recordClass;
		this.table = recordClass.getSimpleName();
	}

	public T insert(T record) {
		record.setId(fileManager.getNextAvailableId(table));
		return save(record);
	}
	
	public T save(T record) {
		try {
			mapper.writeValue(fileManager.getFile(table, record.getId()), record);
		} catch (JsonGenerationException e) {
			logger.error("[ERROR]", e);
		} catch (JsonMappingException e) {
			logger.error("[ERROR]", e);
		} catch (IOException e) {
			logger.error("[ERROR]", e);
		}
		
		return record;
	}
	
	public T select(long id) {
		T record = null;
		
		try {
			record = (T) mapper.readValue(fileManager.getFile(table, id), recordClass);
		} catch (JsonParseException e) {
			logger.error("[ERROR]", e);
		} catch (JsonMappingException e) {
			logger.error("[ERROR]", e);
		} catch (IOException e) {
			logger.error("[ERROR]", e);
		}
		
		return record;
	}
	
	public List<T> select() {
		List<T> recordList = new ArrayList<T>();
		
		for (Long id : fileManager.getPaths(table).keySet()) {
			recordList.add(select(id));
		}
		
		return recordList;
	}
}
