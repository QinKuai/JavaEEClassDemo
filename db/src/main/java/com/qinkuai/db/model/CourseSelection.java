package com.qinkuai.db.model;

import java.util.Objects;

import lombok.Data;

@Data
public class CourseSelection {
	private String sid;
	private String cid;
	private int score;
	
	@Override
	public int hashCode() {
		return Objects.hash(sid, cid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CourseSelection)) {
			return false;
		}
		CourseSelection courseSelection = (CourseSelection) obj;
		return Objects.equals(courseSelection.sid, sid) && Objects.equals(courseSelection.cid, cid);
	}
}
