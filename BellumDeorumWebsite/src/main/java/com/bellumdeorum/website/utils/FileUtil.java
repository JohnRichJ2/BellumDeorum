package com.bellumdeorum.website.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {	
	private static FileUtil instance = new FileUtil();
	
	private FileUtil() { }
	
	public static FileUtil getInstance() {
		return instance;
	}
	
	public File getFile(String className, long id) {
		File file = new File(getPath(className, id));
		
		if (!file.exists()) {
			createNewFile(file);
		}
		
		return file;
	}
	
	public String getPath(String className, long id) {
		return String.format("./simpledb/bellumdeorum/%s/%d.json", className.toLowerCase(), id);
	}
	
	public Map<Long, String> getPaths(String className) {
		File folder = new File(getPath(className, 1L)).getParentFile();
		Map<Long, String> map = new HashMap<Long, String>();
		
		if (folder.exists()) {
			String[] paths = folder.list(new JSONFilter());
			for(String path : paths) {
				Long id = Long.parseLong(path.replace(".json", ""));
				map.put(id, getPath(className, id));
			}
		}
		
		return map;
	}
	
	public long getNextAvailableId(String className) {
		long nextId = 100L;
		
		for (Long id : getPaths(className).keySet()) {
			nextId = (nextId > id) ? nextId : id;
		}
		
		return ++nextId;
	}
	
	public boolean createNewFile(File file) {
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean createNewFile(String className, long id) {
		return createNewFile(new File(getPath(className, id)));
	}
	
	
	public class JSONFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return (name.endsWith(".json"));
		}
	}
}
