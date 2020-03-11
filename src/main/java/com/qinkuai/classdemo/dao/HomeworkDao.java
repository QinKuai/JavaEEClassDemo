package com.qinkuai.classdemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qinkuai.classdemo.model.Homework;
import com.qinkuai.classdemo.util.FieldUtils;
import com.qinkuai.classdemo.util.TimeUtils;

public class HomeworkDao {
	private static HomeworkDao homeworkDao;
	private static List<Class<?>> homeworkFieldClasses;
	
	private HomeworkDao() {}
	
	public static HomeworkDao getInstance() {
		if (homeworkDao == null) {
			homeworkDao = new HomeworkDao();
			homeworkFieldClasses = new ArrayList<Class<?>>();
			FieldUtils.getClassFields(homeworkFieldClasses, Homework.class);
		}
		return homeworkDao;
	}
	
	// 插入任务信息
	public void insert(Homework record) {
		StringBuilder sql = new StringBuilder("insert into homework(sid,taskid,content,upload_time) values('");
		sql.append(record.getSid()).append("',").append(record.getTaskId()).append(",'")
		.append(record.getContent()).append("','").append(TimeUtils.dateToString(record.getUploadTime())).append("');");
		
		try {
			JDBCTemplate.opExceptSelect(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 通过任务号查找任务信息
	public Homework selectById(int homeworkId) {
		StringBuilder sql = new StringBuilder("select * from task where id=");
		sql.append(homeworkId);
		
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), homeworkFieldClasses);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if (resultList.size() > 0) {
			Homework homework = new Homework();
			setFields(homework, resultList.get(0));
			return homework;
		}else {
			return null;
		}
	}
	
	// 通过学生id和任务id查找作业列表
	public List<Homework> selectByCourseId(String sid, int taskId){
		StringBuilder sql = new StringBuilder("select * from homework where sid='");
		sql.append(sid).append("' and taskid=").append(taskId).append(";");
		
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), homeworkFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Homework> homeworks = new ArrayList<>();
		for (List<Object> list : resultList) {
			Homework homework = new Homework();
			setFields(homework, list);
			homeworks.add(homework);
		}
		
		return homeworks;
	}
	
	// 获取所有作业列表
	public List<Homework> selectAll(){
		StringBuilder sql = new StringBuilder("select * from homework order by id;");
	
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), homeworkFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Homework> homeworks = new ArrayList<>();
		for (List<Object> list : resultList) {
			Homework homework = new Homework();
			setFields(homework, list);
			homeworks.add(homework);
		}
		
		return homeworks;
	}
	
	// 获取同一任务下的作业列表
	public List<Homework> selectByTaskId(int taskId){
		StringBuilder sql = new StringBuilder("select * from homework where taskid=");
		sql.append(taskId).append(";");
		
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), homeworkFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Homework> homeworks = new ArrayList<>();
		for (List<Object> list : resultList) {
			Homework homework = new Homework();
			setFields(homework, list);
			homeworks.add(homework);
		}
		
		return homeworks;
	}
	
	// 设置任务字段信息
	private void setFields(Homework homework, List<Object> list) {
		homework.setId((Integer)list.get(0));
		homework.setSid((String)list.get(1));
		homework.setTaskId((Integer)list.get(2));
		homework.setContent((String)list.get(3));
		homework.setUploadTime((Date)list.get(4));
	}
	
	
}
