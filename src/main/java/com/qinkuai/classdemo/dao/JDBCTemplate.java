package com.qinkuai.classdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qinkuai.classdemo.util.ApplicationProperties;

public class JDBCTemplate {
	// 数据源驱动
	private static String driver = ApplicationProperties.getInstance().getProperty("driver-class-name");
	// 数据源地址
	private static String url = ApplicationProperties.getInstance().getProperty("db-url");
	// 用户名
	private static String username = ApplicationProperties.getInstance().getProperty("username");
	// 密码
	private static String password = ApplicationProperties.getInstance().getProperty("password");
	
	private JDBCTemplate() {}
	
	// 除去select以外的update,delete,insert操作
	public static int opExceptSelect(String sql) throws Exception{
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()){
			return statement.executeUpdate(sql);
		} 
	}
	
	// select操作，默认返回获取到的结果集
	public static List<List<Object>> opSelect(String sql, List<Class<?>> cols) throws Exception{
		Class.forName(driver);
		List<List<Object>> resultList = new ArrayList<>();
		List<Object> objContent = null;
		try(Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql)){
			while (rs.next()) {
				objContent = new ArrayList<>();
				for (int i = 1; i <= cols.size(); i++) {
					objContent.add(rs.getObject(i, cols.get(i - 1)));
				}
				resultList.add(objContent);
			}
		}
		
		return resultList;
	}
}
