package com.qinkuai.classdemo.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.classdemo.dao.CourseSelectionDao;
import com.qinkuai.classdemo.dao.StudentDao;
import com.qinkuai.classdemo.model.Student;

@WebServlet("/add-student-to-course")
public class AddStudentToCourseServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = StudentDao.getInstance().selectById(req.getParameter("sid"));
		String cid = req.getParameter("courseId");
		if (student != null) {
			CourseSelectionDao.getInstance().insert(cid, student.getId(), 0);
		}
		super.doPost(req, resp);
	}
}
