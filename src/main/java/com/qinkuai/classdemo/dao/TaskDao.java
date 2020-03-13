package com.qinkuai.classdemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qinkuai.classdemo.model.Task;
import com.qinkuai.classdemo.util.FieldUtils;
import com.qinkuai.classdemo.util.TimeUtils;

public class TaskDao {
	private static TaskDao taskDao;
	private static List<Class<?>> taskFieldClasses;
	
	private TaskDao() {}
	
	public static TaskDao getInstance() {
		if (taskDao == null) {
			taskDao = new TaskDao();
			taskFieldClasses = new ArrayList<Class<?>>();
			FieldUtils.getClassFields(taskFieldClasses, Task.class);
		}
		return taskDao;
	}
	
	// 插入任务信息
	public void insert(Task record) {
		StringBuilder sql = new StringBuilder("insert into task(cid,content,upload_time,start_time,time_last) values('");
		sql.append(record.getCid()).append("','").append(record.getContent()).append("','")
		.append(TimeUtils.dateToString(record.getUploadTime())).append("','")
		.append(TimeUtils.dateToString(record.getStartTime())).append("',").append(record.getTimeLast()).append(");");
		
		try {
			JDBCTemplate.opExceptSelect(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 通过任务号查找任务信息
	public Task selectById(int id) {
		StringBuilder sql = new StringBuilder("select * from task where id=");
		sql.append(id).append(";");
		
		List<Object> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), taskFieldClasses).get(0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Task task = new Task();
		
		setFields(task, resultList);
		
		return task;
	}
	
	// 通过任务课程号查找任务列表
	public List<Task> selectByCourseId(String id){
		StringBuilder sql = new StringBuilder("select * from task where cid='");
		sql.append(id).append("';");
		
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), taskFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Task> tasks = new ArrayList<>();
		for (List<Object> list : resultList) {
			Task task = new Task();
			setFields(task, list);
			tasks.add(task);
		}
		
		return tasks;
	}
	
	// 获取所有任务列表
	public List<Task> selectAll(){
		StringBuilder sql = new StringBuilder("select * from student order by id;");
	
		List<List<Object>> resultList = null;
		try {
			resultList = JDBCTemplate.opSelect(sql.toString(), taskFieldClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Task> tasks = new ArrayList<>();
		for (List<Object> list : resultList) {
			Task task = new Task();
			setFields(task, list);
			tasks.add(task);
		}
		
		return tasks;
	}
	
	// 设置任务字段信息
	private void setFields(Task task, List<Object> list) {
		task.setId((Integer)list.get(0));
		task.setCid((String)list.get(1));
		task.setContent((String)list.get(2));
		task.setUploadTime((Date)list.get(3));
		task.setStartTime((Date)list.get(4));
		task.setTimeLast((Integer)list.get(5));
	}
	
	
}
