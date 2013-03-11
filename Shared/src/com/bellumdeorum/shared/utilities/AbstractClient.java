package com.bellumdeorum.shared.utilities;

import java.io.IOException;
import java.net.URLEncoder;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractClient <I, O> {
	private static final Logger logger = LoggerFactory.getLogger(AbstractClient.class);
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	private final Class<O> outputClass;
	private final String url;
	
	public AbstractClient(Class<O> outputClass, String serviceEndpoint, String method) {
		this.outputClass = outputClass;
		url = String.format("%s/%s/{json}", serviceEndpoint, method);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
	}
	
	public abstract O call(I input);
	
	protected O get(I input) {
		O output = null;
		
		String json = valueAsString(input);
		if (json != null) {
			RestTemplate restTemplate = new RestTemplate();
			output = (O)restTemplate.getForObject(url, outputClass, json);
		}
		
		return output;
	}
	
	protected O post(I input) {
		O output = null;
		
		String json = valueAsString(input);
		if (json != null) {
			RestTemplate restTemplate = new RestTemplate();
			output = (O)restTemplate.postForObject(url, null, outputClass, json);
		}
		
		return output;
	}
	
	private String valueAsString(Object value) {
		try {
			return URLEncoder.encode(mapper.writeValueAsString(value).replace(".", "<DOT>"), "UTF-8");
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
