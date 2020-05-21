package com.qinkuai.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qinkuai.db.dao.CourseSelectionMapper;
import com.qinkuai.db.dao.StudentMapper;
import com.qinkuai.db.dao.TaskMapper;
import com.qinkuai.db.model.CourseSelection;
//
import com.qinkuai.db.model.Student;
import com.qinkuai.db.model.Task;

@Controller
public class CourseController {
	@Autowired
	private CourseSelectionMapper courseSelectionDao;
	@Autowired
	private StudentMapper studentDao;
	@Autowired
	private TaskMapper taskDao;
	
	@RequestMapping(value = "/course-detail", method = RequestMethod.GET)
	public String courseDetail(HttpServletRequest request, HttpServletResponse response) {
		String courseId = "RJZ001_01";
		List<Student> students = studentDao.selectByCourseId(courseId);
		List<Task> tasks = taskDao.selectByCourseId(courseId);
		
		request.setAttribute("courseId", courseId);
		request.setAttribute("students", students);
		request.setAttribute("tasks", tasks);
		
		return "course-detail";
	}

	@RequestMapping(value = "/add-student-to-course")
	public void addStudentToCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Student student = studentDao.selectByPrimaryKey(request.getParameter("sid"));
		String cid = request.getParameter("cid");
		
		if (student != null && courseSelectionDao.selectByPrimaryKey(student.getId(), cid) == null) {
			courseSelectionDao.insert(new CourseSelection(student.getId(), cid, 0));
		}
		
		request.setAttribute("courseId", cid);
		response.sendRedirect("course-detail");
	}
}
