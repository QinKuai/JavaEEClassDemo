package com.qinkuai.core.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Student {
	// 学生ID
	private String id;
	// 学生姓
	private String firstName;
	// 学生名
	private String lastName;
	// 学生性别
	private String sex;
	// 学生班级名
	private String className;
	// 学生年级
	private String grade;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
}
