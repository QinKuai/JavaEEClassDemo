package com.qinkuai.core.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Teacher {
	// 教师id
	private String id;
	// 教师姓
	private String firstName;
	// 教师名
	private String lastName;
	// 性别
	private String sex;
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !( o instanceof Teacher)) {
			return false;
		}
		
		Teacher t = (Teacher) o;
		return Objects.equals(id, t.id);
	}
}
