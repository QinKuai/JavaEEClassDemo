package com.qinkuai.db.model;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class Teacher extends AbstractUser{
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
