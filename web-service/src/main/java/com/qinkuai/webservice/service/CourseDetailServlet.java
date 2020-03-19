package com.qinkuai.webservice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("courseId", "RJZ001_01");
		
		req.getRequestDispatcher("WEB-INF/webapp/jsp/course-detail.jsp").forward(req, resp);
	}
}
