package com.qinkuai.classdemo.util;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
	// 单例模式
	private static ApplicationProperties instance;
	// prop对象
	private static Properties properties;
	
	private ApplicationProperties() {}
	
	public static ApplicationProperties getInstance() {
		if (instance == null) {
			instance = new ApplicationProperties();
			properties = new Properties();
			try {
				properties.load(ApplicationProperties.class.getResourceAsStream("/application.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
