package com.qinkuai.classdemo.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.classdemo.dao.StudentDao;
import com.qinkuai.classdemo.model.Student;

public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/webapp/jsp/index.jsp").forward(req, resp);
	}
	
}
