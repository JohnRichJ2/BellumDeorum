package com.bellumdeorum.userservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.bellumdeorum.userservice.models.User;

public interface InitUsers {
	
	public static final Long USER_VERSION = 2L;
	
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
}
