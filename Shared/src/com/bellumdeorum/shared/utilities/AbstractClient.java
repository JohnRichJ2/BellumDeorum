package com.bellumdeorum.shared.utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient <T> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractClient.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private final Class<T> responseClass;
	private final String url;
	
	public AbstractClient(Class<T> responseClass, String serviceEndpoint, String method) {
		this.responseClass = responseClass;
		url = String.format("%s/%s/{json}", serviceEndpoint, method);
	}
	
	public T get(Object request) {
		T response = null;
		
		String json = valueAsString(request);
		if (json != null) {
			RestTemplate restTemplate = new RestTemplate();
			response = (T)restTemplate.getForObject(url, responseClass, json);
		}
		
		return response;
	}
	
	public T post(Object request) {
		T response = null;
		
		String json = valueAsString(request);
		if (json != null) {
			RestTemplate restTemplate = new RestTemplate();
			response = (T)restTemplate.postForObject(url, null, responseClass, json);
		}
		
		return response;
	}
	
	private String valueAsString(Object value) {
		try {
			return mapper.writeValueAsString(value);
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
