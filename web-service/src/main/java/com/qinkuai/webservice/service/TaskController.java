package com.qinkuai.webservice.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.core.dao.TaskDao;
import com.qinkuai.core.model.Task;
import com.qinkuai.core.util.TimeUtils;

@Controller
public class TaskController {
	
	@RequestMapping(value = "task-detail", method = RequestMethod.GET)
	public String taskDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cid", "RJZ001_01");
		request.setAttribute("taskid", 1);
		return "task-detail";
	}
	
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
		
		TaskDao.getInstance().insert(task);
		
		response.sendRedirect("course-detail");
	}
}
