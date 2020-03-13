package com.qinkuai.classdemo.dao;

import java.util.ArrayList;
import java.util.List;

import com.qinkuai.classdemo.model.CourseSelection;
import com.qinkuai.classdemo.util.FieldUtils;

public class CourseSelectionDao {
	private static CourseSelectionDao courseSelectionDao;
	private static List<Class<?>> cSFieldClasses;
	
	private CourseSelectionDao() {}
	
	public static CourseSelectionDao getInstance() {
		if (courseSelectionDao == null) {
			courseSelectionDao = new CourseSelectionDao();
			cSFieldClasses = new ArrayList<Class<?>>();
			FieldUtils.getClassFields(cSFieldClasses, CourseSelection.class);
		}
		return courseSelectionDao;
	}
	
	public void insert(String cid, String sid, int score) {
		StringBuilder sql = new StringBuilder("insert into course_selection values('");
		sql.append(cid).append("','").append(sid).append("',").append(score).append(");");
		
		try {
			JDBCTemplate.opExceptSelect(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isCourseSelected(String cid, String sid) {
		StringBuilder sql = new StringBuilder("select * from course_selection where sid='");
		sql.append(sid).append("' and cid='").append(cid).append("';");
		
		List<List<Object>> resultList = null; 
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), cSFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (resultList != null && resultList.size() > 0) ? true : false;
	}
	
}
