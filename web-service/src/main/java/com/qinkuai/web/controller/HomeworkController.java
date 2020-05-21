package com.qinkuai.web.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.db.dao.HomeworkMapper;
import com.qinkuai.db.dao.StudentMapper;
import com.qinkuai.db.model.Homework;
import com.qinkuai.db.model.Student;

@Controller
public class HomeworkController {
	@Autowired
	private HomeworkMapper homeworkDao;
	@Autowired
	private StudentMapper studentDao;
	
	@RequestMapping(value = "/homework-detail", method = RequestMethod.GET)
	public String homeworkDetail(HttpServletRequest request, HttpServletResponse response) {
		String studentId = "17301087";
		int taskId = 1;
		Student student = studentDao.selectByPrimaryKey(studentId);
		List<Homework> homeworks = homeworkDao.selectByStudentIdAndTaskId(studentId, taskId);
		request.setAttribute("cid", "RJZ001_01");
		request.setAttribute("student", student);
		request.setAttribute("homeworks", homeworks);
		return "homework-detail";
	}
	
	@RequestMapping(value = "/add-homework", method = RequestMethod.GET)
	public String addHomeworkPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("sid", "17301087");
		request.setAttribute("taskId", 1);
		return "add-homework";
	}
	
	@RequestMapping(value = "/add-homework", method =  RequestMethod.POST)
	public void addHomework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Homework homework = new Homework();
		homework.setSid(request.getParameter("sid"));
		homework.setTaskId(Integer.valueOf(request.getParameter("taskId")));
		homework.setContent(request.getParameter("content"));
		homework.setUploadTime(Calendar.getInstance().getTime());
		
		homeworkDao.insert(homework);
		
		response.sendRedirect("task-detail");
	}
}
