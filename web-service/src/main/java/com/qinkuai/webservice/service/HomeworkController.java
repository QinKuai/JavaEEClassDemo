package com.qinkuai.webservice.service;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.core.dao.HomeworkDao;
import com.qinkuai.core.model.Homework;

@Controller
public class HomeworkController {
	@RequestMapping(value = "/homework-detail", method = RequestMethod.GET)
	public String homeworkDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("cid", "RJZ001_01");
		request.setAttribute("sid", "17301087");
		request.setAttribute("taskid", 1);
		return "homework-detail";
	}
	
	@RequestMapping(value = "/add-homework", method =  RequestMethod.POST)
	public void addHomework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Homework homework = new Homework();
		homework.setSid(request.getParameter("sid"));
		homework.setTaskId(Integer.valueOf(request.getParameter("taskId")));
		homework.setContent(request.getParameter("content"));
		homework.setUploadTime(Calendar.getInstance().getTime());
		
		HomeworkDao.getInstance().insert(homework);
		
		response.sendRedirect("task-detail");
	}
}
