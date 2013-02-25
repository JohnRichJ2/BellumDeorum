package com.bellumdeorum.website.utils;

import com.bellumdeorum.website.models.Empire;
import com.bellumdeorum.website.models.User;

public class Constants {
	public static final User USER_JOHN = new User(1L, "john", "john@gmail.com", "pass");
	public static final User USER_WOLF = new User(2L, "wolf", "wolf@gmail.com", "pass");
	public static final User USER_JOE = new User(3L, "joe", "joe@gmail.com", "test");
	public static final User USER_BOPH = new User(4L, "boph", "boph@gmail.com", "test");
	
	public static final Empire EMPIRE_JOHN = new Empire(100L, USER_JOHN, "John's Empire");
	public static final Empire EMPIRE_WOLF = new Empire(101L, USER_WOLF, "Wolf's Empire");
	public static final Empire EMPIRE_JOE = new Empire(102L, USER_JOE, "Joe's Empire");
	public static final Empire EMPIRE_BOPH = new Empire(103L, USER_BOPH, "Boph's Empire");
}
