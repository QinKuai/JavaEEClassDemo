package com.qinkuai.webservice.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.core.util.TimeUtils;
import com.qinkuai.db.dao.HomeworkDao;
import com.qinkuai.db.dao.TaskDao;
import com.qinkuai.db.model.Homework;
import com.qinkuai.db.model.Task;

@Controller
public class TaskController {
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private HomeworkDao homeworkDao;
	
	@RequestMapping(value = "task-detail", method = RequestMethod.GET)
	public String taskDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cid", "RJZ001_01");
		int taskId = 1;
		Task task = taskDao.selectById(taskId);
		List<Homework> homeworks = homeworkDao.selectByTaskId(taskId);
		request.setAttribute("task", task);
		request.setAttribute("homeworks", homeworks);
		return "task-detail";
	}
	
	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String addTaskPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("courseId", "RJZ001_01");
		return "add-task";
	}
	
	@RequestMapping(value = "add-task", method = RequestMethod.POST)
	public void addTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf8");
		Task task = new Task();
		task.setCid(request.getParameter("cid"));
		task.setContent(request.getParameter("content"));
		task.setUploadTime(Calendar.getInstance().getTime());
		try {
			task.setStartTime(TimeUtils.stringToDate(request.getParameter("upload_time")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setTimeLast(Integer.valueOf(request.getParameter("time_last")));
		
		taskDao.insert(task);
		
		response.sendRedirect("course-detail");
	}
}
