package com.qinkuai.classdemo.model;

import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Task {
	// 作业id
	private int id;
	// 课程id
	private String cid;
	// 内容
	private String content;
	// 任务上传时间
	private Date uploadTime;
	// 任务开始时间
	private Date startTime;
	// 任务持续时长，h为单位
	private int timeLast;
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !( o instanceof Task)) {
			return false;
		}
		
		Task t = (Task) o;
		return Objects.equals(id, t.id);
	}
}
