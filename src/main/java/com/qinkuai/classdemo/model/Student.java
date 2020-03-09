package com.qinkuai.classdemo.model;

import lombok.Data;

@Data
public class Student {
	// 学生ID
	private String id;
	// 学生姓名
	private String name;
	// 学生性别
	private String sex;
	// 学生班级名
	private String className;
	// 学生年级
	private String grade;
}
