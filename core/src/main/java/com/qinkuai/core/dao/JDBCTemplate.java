package com.qinkuai.core.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate {
	
	private JDBCTemplate() {}
	
	// 除去select以外的update,delete,insert操作
	public static int opExceptSelect(String sql) throws Exception{
		try (Connection connection = DataBaseCP.getConnectionPool().getConnection();
				Statement statement = connection.createStatement()){
			return statement.executeUpdate(sql);
		} 
	}
	
	// select操作，默认返回获取到的结果集
	public static List<List<Object>> opSelect(String sql, List<Class<?>> cols) throws Exception{
		List<List<Object>> resultList = new ArrayList<>();
		List<Object> objContent = null;
		try(Connection connection = DataBaseCP.getConnectionPool().getConnection();
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
