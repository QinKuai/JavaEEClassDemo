package com.qinkuai.classdemo.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.qinkuai.classdemo.model.Student;

public class StudentDao {
	private static StudentDao studentDao;
	private static List<Class<?>> studentFieldClasses;
	
	private StudentDao() {}
	
	public static StudentDao getInstance() {
		if (studentDao == null) {
			studentDao = new StudentDao();
			studentFieldClasses = new ArrayList<Class<?>>();
			for (Field field : Student.class.getDeclaredFields()) {
				studentFieldClasses.add(field.getType());
			}
		}
		return studentDao;
	}
	
	// 插入学生信息
	//public int insert(Student record) {
	//	StringBuilder sql = new StringBuilder();
		
		
		
	//}
	
	// 通过学生学号查找学生信息
	public Student selectById(String id) {
		StringBuilder sql = new StringBuilder("select * from student where id=");
		sql.append(id);
		
		List<Object> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), studentFieldClasses).get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Student student = new Student();
		
		setStudentFields(student, resultList);
		
		return student;
	}
	
	// 获取所有学生信息
	public List<Student> selectAll(){
		StringBuilder sql = new StringBuilder("select * from student order by id");
	
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), studentFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Student> students = new ArrayList<>();
		for (List<Object> list : resultList) {
			Student student = new Student();
			setStudentFields(student, list);
			students.add(student);
		}
		
		return students;
	}
	
	// 设置学生信息
	private void setStudentFields(Student student, List<Object> list) {
		student.setId((String)list.get(0));
		student.setFirstName((String)list.get(1));
		student.setLastName((String)list.get(2));
		student.setSex((String)list.get(3));
		student.setClassName((String)list.get(4));
		student.setGrade((String)list.get(5));
	}
	
	
}
