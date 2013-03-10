package com.bellumdeorum.shared.utilities;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class AbstractService <I, O> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractService.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private final Class<I> requestClass;
	
	public AbstractService(Class<I> requestClass) {
		this.requestClass = requestClass;
	}
	
	public abstract O enact(HttpServletRequest request, HttpServletResponse response, 
			Locale locale, ModelMap model, @PathVariable("json") String json);
	
	public I requestValue(String json) {
		try {
			I value = mapper.readValue(json, requestClass);
			return value;
		} catch (JsonParseException e) {
			logger.error("[ERROR]", e);
		} catch (JsonGenerationException e) {
			logger.error("[ERROR]", e);
		} catch (JsonMappingException e) {
			logger.error("[ERROR]", e);
		} catch (IOException e) {
			logger.error("[ERROR]", e);
		}
		
		return null;
	}
}
