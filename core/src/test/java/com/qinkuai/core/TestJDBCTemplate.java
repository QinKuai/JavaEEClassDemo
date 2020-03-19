package com.qinkuai.core;

import java.util.List;

import com.qinkuai.core.dao.StudentDao;
import com.qinkuai.core.model.Student;
import com.qinkuai.core.util.ApplicationProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestJDBCTemplate {

	public static void main(String[] args) {
		List<Student> students = StudentDao.getInstance().selectAll();
		for (Student student : students) {
			System.out.println(student);
		}

		HikariConfig config = new HikariConfig();

		ApplicationProperties properties = ApplicationProperties.getInstance();
		config.setJdbcUrl(properties.getProperty("db-url"));
		config.setUsername(properties.getProperty("username"));
		config.setPassword(properties.getProperty("password"));
		config.setDriverClassName(properties.getProperty("driver-class-name"));

		for (int i = 0; i < 2; i++) {
			HikariDataSource dbDS = new HikariDataSource(config);
		}

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
