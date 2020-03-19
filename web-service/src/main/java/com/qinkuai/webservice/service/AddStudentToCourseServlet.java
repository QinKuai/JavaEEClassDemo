package com.qinkuai.webservice.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.core.dao.CourseSelectionDao;
import com.qinkuai.core.dao.StudentDao;
import com.qinkuai.core.model.Student;

@WebServlet("/add-student-to-course")
public class AddStudentToCourseServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = StudentDao.getInstance().selectById(req.getParameter("sid"));
		String cid = req.getParameter("cid");
		
		if (student != null && !CourseSelectionDao.getInstance().isCourseSelected(cid, student.getId())) {
			CourseSelectionDao.getInstance().insert(cid, student.getId(), 0);
		}
		req.setAttribute("courseId", cid);
		resp.sendRedirect("course-detail");
	}
}
