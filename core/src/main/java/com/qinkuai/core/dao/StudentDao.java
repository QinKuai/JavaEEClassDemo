package com.qinkuai.core.dao;

import java.util.ArrayList;
import java.util.List;

import com.qinkuai.core.util.FieldUtils;
import com.qinkuai.core.model.Student;

public class StudentDao {
	private static StudentDao studentDao;
	private static List<Class<?>> studentFieldClasses;
	
	private StudentDao() {}
	
	public static StudentDao getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDao();
			studentFieldClasses = new ArrayList<Class<?>>();
			FieldUtils.getClassFields(studentFieldClasses, Student.class);
		}
		return studentDao;
	}
	
	// 插入学生信息
	public void insert(Student record) {
		StringBuilder sql = new StringBuilder("insert into student values('");
		sql.append(record.getId()).append("','").append(record.getFirstName()).append("','")
		.append(record.getLastName()).append("','").append(record.getSex()).append("','")
		.append(record.getClassName()).append("','").append(record.getGrade()).append("');");
		
		try {
			JDBCTemplate.opExceptSelect(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 通过学生学号查找学生信息
	public Student selectById(String id) {
		StringBuilder sql = new StringBuilder("select * from student where id='");
		sql.append(id).append("';");
		
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), studentFieldClasses);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (resultList.size() <= 0) {
			return null;
		}else {
			Student student = new Student();
			setFields(student, resultList.get(0));
			return student;
		}
	}
	
	// 获取所有学生信息
	public List<Student> selectAll(){
		StringBuilder sql = new StringBuilder("select * from student order by id;");
	
		return getStudentList(sql.toString());
	}
	
	// 获取在同一课堂上的学生信息
	public List<Student> selectByCourseId(String courseId){
		StringBuilder sql = new StringBuilder("select id,firstName,lastName,sex,class,grade");
		sql.append(" from student,course_selection where student.id=course_selection.sid and cid='").append(courseId).append("';");
		
		return getStudentList(sql.toString());
	}
	
	private List<Student> getStudentList(String sql){
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql, studentFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Student> students = new ArrayList<>();
		for (List<Object> list : resultList) {
			Student student = new Student();
			setFields(student, list);
			students.add(student);
		}
		
		return students;
	}
	
	// 设置学生信息
	private void setFields(Student student, List<Object> list) {
		student.setId((String)list.get(0));
		student.setFirstName((String)list.get(1));
		student.setLastName((String)list.get(2));
		student.setSex((String)list.get(3));
		student.setClassName((String)list.get(4));
		student.setGrade((String)list.get(5));
	}
	
	
}
