package com.qinkuai.webservice.oldversion;

import java.io.IOException;

import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.core.dao.HomeworkDao;
import com.qinkuai.core.model.Homework;
import com.qinkuai.core.util.ApplicationProperties;

public class AddHomeworkServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("sid", "17301087");
		req.setAttribute("taskId", 1);
		req.getRequestDispatcher(ApplicationProperties.getInstance().getProperty("static-path") + "/jsp/add-homework.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Homework homework = new Homework();
		homework.setSid(req.getParameter("sid"));
		homework.setTaskId(Integer.valueOf(req.getParameter("taskId")));
		homework.setContent(req.getParameter("content"));
		homework.setUploadTime(Calendar.getInstance().getTime());
		
		HomeworkDao.getInstance().insert(homework);
		
		resp.sendRedirect("task-detail");
	}
}
