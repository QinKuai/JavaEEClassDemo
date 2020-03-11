package com.qinkuai.test;

import java.text.SimpleDateFormat;

import com.qinkuai.classdemo.dao.HomeworkDao;
import com.qinkuai.classdemo.dao.StudentDao;
import com.qinkuai.classdemo.model.Homework;
import com.qinkuai.classdemo.model.Student;

public class Test {
	
	public static void main(String[] args) throws Exception{
		for (Homework homework : HomeworkDao.getInstance().selectAll()) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(homework.getUploadTime()));
		}
		
	}
	
}
