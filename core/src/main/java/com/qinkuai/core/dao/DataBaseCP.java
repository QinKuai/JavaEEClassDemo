package com.qinkuai.core.dao;

import com.qinkuai.core.util.ApplicationProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseCP {
	private static HikariDataSource dbDS;
	
	private DataBaseCP() {}
	
	public static HikariDataSource getConnectionPool() {
		if (dbDS == null) {
			dbDSInit();
		}
		return dbDS;
	}
	
	private static void dbDSInit() {
		HikariConfig config = new HikariConfig();
		
		ApplicationProperties properties = ApplicationProperties.getInstance();
		config.setJdbcUrl(properties.getProperty("db-url"));
		config.setUsername(properties.getProperty("username"));
		config.setPassword(properties.getProperty("password"));
		config.setDriverClassName(properties.getProperty("driver-class-name"));
		
		dbDS = new HikariDataSource(config);
	}
}
