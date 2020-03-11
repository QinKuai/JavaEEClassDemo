package com.qinkuai.classdemo.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.classdemo.dao.TaskDao;
import com.qinkuai.classdemo.model.Task;
import com.qinkuai.classdemo.util.ApplicationProperties;
import com.qinkuai.classdemo.util.TimeUtils;

public class AddTaskServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("courseId", "RJZ001_01");
		req.getRequestDispatcher(ApplicationProperties.getInstance().getProperty("static-path") + "jsp/add-task.jsp").forward(req, resp);
	}
	
//	@Override
///	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Task task = new Task();
//		task.setCid(req.getParameter("cid"));
//		task.setContent(req.getParameter("content"));
//		task.setUploadTime(Calendar.getInstance().getTime());
//		try {
//			task.setStartTime(TimeUtils.stringToDate(req.getParameter("upload_time")));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		task.setTimeLast(Integer.getInteger(req.getParameter("time_last")));
//		
//		TaskDao.getInstance().insert(task);
//		
//		resp.sendRedirect("course-detail");
//		super.doPost(req, resp);
//	}
}
