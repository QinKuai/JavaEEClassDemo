package com.qinkuai.webservice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.core.util.ApplicationProperties;

@WebServlet("/task-detail")
public class TaskDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("cid", "RJZ001_01");
		req.setAttribute("taskid", 1);
		req.getRequestDispatcher(ApplicationProperties.getInstance().getProperty("static-path") + "jsp/task-detail.jsp").forward(req, resp);
	}
}
