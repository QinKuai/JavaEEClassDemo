package com.qinkuai.webservice.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.db.dao.CourseSelectionDao;
import com.qinkuai.db.dao.StudentDao;
import com.qinkuai.db.dao.TaskDao;
import com.qinkuai.db.model.Student;
import com.qinkuai.db.model.Task;

@Controller
public class CourseController {
	@Autowired
	private CourseSelectionDao courseSelectionDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TaskDao taskDao;
	
	@RequestMapping(value = "/course-detail", method = RequestMethod.GET)
	public String courseDetail(HttpServletRequest request, HttpServletResponse response) {
		String courseId = "RJZ001_01";
		List<Student> students = studentDao.selectAll();
		List<Task> tasks = taskDao.selectByCourseId(courseId);
		
		request.setAttribute("courseId", courseId);
		request.setAttribute("students", students);
		request.setAttribute("tasks", tasks);
		
		return "course-detail";
	}

	@RequestMapping(value = "/add-student-to-course")
	public void addStudentToCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Student student = studentDao.selectById(request.getParameter("sid"));
		String cid = request.getParameter("cid");
		
		courseSelectionDao.insert("RJZ002_01", "0000000", 70);
		
		if (student != null && !courseSelectionDao.isCourseSelected(cid, student.getId())) {
			courseSelectionDao.insert(cid, student.getId(), 0);
		}
		
		request.setAttribute("courseId", cid);
		response.sendRedirect("course-detail");
	}
}
