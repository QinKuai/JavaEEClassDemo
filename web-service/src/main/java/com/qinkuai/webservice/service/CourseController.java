package com.qinkuai.webservice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.core.dao.CourseSelectionDao;
import com.qinkuai.core.dao.StudentDao;
import com.qinkuai.core.model.Student;

@Controller
public class CourseController {
	@Autowired
	private CourseSelectionDao courseSelectionDao;
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value = "/course-detail", method = RequestMethod.GET)
	public String courseDetail(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("courseId", "RJZ001_01");
		
		return "course-detail";
	}
	
	@RequestMapping(value = "/add-student-to-course")
	public void addStudentToCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Student student = studentDao.selectById(request.getParameter("sid"));
		String cid = request.getParameter("cid");
		
		if (student != null && !courseSelectionDao.isCourseSelected(cid, student.getId())) {
			courseSelectionDao.insert(cid, student.getId(), 0);
		}
		request.setAttribute("courseId", cid);
		response.sendRedirect("course-detail");
	}
}
