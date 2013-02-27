package com.bellumdeorum.website.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bellumdeorum.website.models.Model;
import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.models.Registration;
import com.bellumdeorum.website.models.User;

public class Constants {
	public static final Long USER_VERSION = 2L;
	public static final Long EMPIRE_VERSION = 1L;
	public static final Long REGISTRATION_VERSION = 1L;
	
	public static final User USER_JOHN = new User() {
		{
			setId(1L);
			setVersion(USER_VERSION);
			setName("john");
			setEmail("john@gmail.com");
			setPassword("pass");
			setStatus(UserStatus.REGISTERED);
		}
	};
	public static final User USER_WOLF = new User() {
		{
			setId(2L);
			setVersion(USER_VERSION);
			setName("wolf");
			setEmail("wolf@gmail.com");
			setPassword("pass");
			setStatus(UserStatus.REGISTERED);
		}
	};
	public static final User USER_JOE = new User() {
		{
			setId(3L);
			setVersion(USER_VERSION);
			setName("joe");
			setEmail("joe@gmail.com");
			setPassword("pass");
			setStatus(UserStatus.REGISTERED);
		}
	};
	public static final User USER_BOPH = new User() {
		{
			setId(4L);
			setVersion(USER_VERSION);
			setName("boph");
			setEmail("boph@gmail.com");
			setPassword("pass");
			setStatus(UserStatus.BANNED);
		}
	};
	@SuppressWarnings("serial")
	public static final List<User> USER_LIST = new ArrayList<User>() {
		{
			add(USER_JOHN);
			add(USER_WOLF);
			add(USER_JOE);
			add(USER_BOPH);
		}
	};
	
	public static final Empire EMPIRE_JOHN = new Empire() {
		{
			setId(100L);
			setVersion(EMPIRE_VERSION);
			setUser(USER_JOHN);
			setName("John's Empire");
		}
	};
	public static final Empire EMPIRE_WOLF = new Empire() {
		{
			setId(101L);
			setVersion(EMPIRE_VERSION);
			setUser(USER_WOLF);
			setName("Wolf's Empire");
		}
	};
	public static final Empire EMPIRE_JOE = new Empire() {
		{
			setId(102L);
			setVersion(EMPIRE_VERSION);
			setUser(USER_JOE);
			setName("Joe's Empire");
		}
	};
	public static final Empire EMPIRE_BOPH = new Empire() {
		{
			setId(103L);
			setVersion(EMPIRE_VERSION);
			setUser(USER_BOPH);
			setName("Boph's Empire");
		}
	};
	@SuppressWarnings("serial")
	public static final List<Empire> EMPIRE_LIST = new ArrayList<Empire>() {
		{
			add(EMPIRE_JOHN);
			add(EMPIRE_WOLF);
			add(EMPIRE_JOE);
			add(EMPIRE_BOPH);
		}
	};
	
	public static <T extends Model> long getVersion(Class<T> modelClass) {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put(User.class.getSimpleName(), USER_VERSION);
		map.put(Empire.class.getSimpleName(), EMPIRE_VERSION);
		map.put(Registration.class.getSimpleName(), REGISTRATION_VERSION);
		return map.get(modelClass.getSimpleName());
	}
	
	@SuppressWarnings("rawtypes")
	public static <T extends Model> List getModels(Class<T> modelClass) {
		Map<String, List> map = new HashMap<String, List>();
		map.put(User.class.getSimpleName(), USER_LIST);
		map.put(Empire.class.getSimpleName(), EMPIRE_LIST);
		map.put(Registration.class.getSimpleName(), null);
		return map.get(modelClass.getSimpleName());
	}
}
