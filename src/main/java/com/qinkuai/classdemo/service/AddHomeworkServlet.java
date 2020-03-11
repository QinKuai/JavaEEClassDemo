package com.qinkuai.classdemo.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.classdemo.dao.HomeworkDao;
import com.qinkuai.classdemo.model.Homework;
import com.qinkuai.classdemo.util.ApplicationProperties;

@WebServlet("/add-homework")
public class AddHomeworkServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("sid", "17301087");
		req.setAttribute("taskId", 1);
		req.getRequestDispatcher(ApplicationProperties.getInstance().getProperty("static-path") + "/jsp/add-homework.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Homework homework = new Homework();
		homework.setSid(req.getParameter("sid"));
		homework.setTaskId(Integer.valueOf(req.getParameter("taskId")));
		homework.setContent(new String(req.getParameter("content").getBytes("ISO-8859-1"), "utf-8"));
		homework.setUploadTime(Calendar.getInstance().getTime());
		
		HomeworkDao.getInstance().insert(homework);
		
		resp.sendRedirect("task-detail");
	}
}
