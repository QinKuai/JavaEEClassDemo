package com.qinkuai.classdemo.model;

import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Homework {
	// 作业id
	private int id;
	// 学生id
	private String sid;
	// 任务id
	private int taskId;
	// 作业内容
	private String content;
	// 上传时间
	private Date uploadTime;
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !( o instanceof Homework)) {
			return false;
		}
		
		Homework t = (Homework) o;
		return Objects.equals(id, t.id);
	}
}
