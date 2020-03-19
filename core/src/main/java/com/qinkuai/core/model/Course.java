package com.qinkuai.core.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Course {
	// 课程id
	private String id;
	// 课程名
	private String courseName;
	// 教师id
	private String tid;
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !( o instanceof Course)) {
			return false;
		}
		
		Course t = (Course) o;
		return Objects.equals(id, t.id);
	}
}
