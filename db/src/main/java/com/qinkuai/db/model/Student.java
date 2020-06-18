package com.qinkuai.db.model;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class Student extends AbstractUser{
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
