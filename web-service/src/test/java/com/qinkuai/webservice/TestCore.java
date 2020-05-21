package com.qinkuai.webservice;

import java.util.List;

import com.qinkuai.db.dao.TaskDao;
import com.qinkuai.db.model.Task;

public class TestCore {
	public static void main(String[] args) {
		List<Task> tasks = TaskDao.getInstance().selectByCourseId("RJZ001_01");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}
}
