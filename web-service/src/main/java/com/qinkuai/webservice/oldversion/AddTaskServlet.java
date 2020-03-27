package com.qinkuai.webservice.oldversion;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qinkuai.core.dao.TaskDao;
import com.qinkuai.core.model.Task;
import com.qinkuai.core.util.ApplicationProperties;
import com.qinkuai.core.util.TimeUtils;

public class AddTaskServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("courseId", "RJZ001_01");
		req.getRequestDispatcher(ApplicationProperties.getInstance().getProperty("static-path") + "jsp/add-task.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf8");
		Task task = new Task();
		task.setCid(req.getParameter("cid"));
		task.setContent(req.getParameter("content"));
		task.setUploadTime(Calendar.getInstance().getTime());
		try {
			task.setStartTime(TimeUtils.stringToDate(req.getParameter("upload_time")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		task.setTimeLast(Integer.valueOf(req.getParameter("time_last")));
		
		TaskDao.getInstance().insert(task);
		
		resp.sendRedirect("course-detail");
	}
}
