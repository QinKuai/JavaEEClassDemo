package com.qinkuai.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	private static String user = "root";
	private static String password = "ab123456";
	
	
	public static void main(String[] args) throws Exception{
		Class.forName(driver);
		String sql = "select * from student";
		
		StringBuilder sb;
		try(Connection connection = DriverManager.getConnection(dbUrl, user, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);){
			while (rs.next()) {
				sb = new StringBuilder();
				sb.append("ID:").append(rs.getString(1)).append(" Name:").append(rs.getString(2)).append(" Grade:").append(rs.getInt(3));
				System.out.println(sb.toString());
			}
		}
	}
	

}
