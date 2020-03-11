package com.qinkuai.classdemo.dao;

public class CourseSelectionDao {
	private static CourseSelectionDao courseSelectionDao;
	
	private CourseSelectionDao() {}
	
	public static CourseSelectionDao getInstance() {
		if (courseSelectionDao == null) {
			courseSelectionDao = new CourseSelectionDao();
		}
		return courseSelectionDao;
	}
	
	public void insert(String cid, String sid, int score) {
		StringBuilder sql = new StringBuilder("insert into course_selection values('");
		sql.append(cid).append("','").append(sid).append("',").append(score).append(");");
		System.out.println(sql.toString());
		
		try {
			JDBCTemplate.opExceptSelect(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
