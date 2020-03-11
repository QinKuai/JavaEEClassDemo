package com.qinkuai.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.qinkuai.classdemo.dao.CourseSelectionDao;
import com.qinkuai.classdemo.model.Student;
import com.qinkuai.classdemo.util.TimeUtils;

public class Test {
	
	public static void main(String[] args) throws Exception{
		System.out.println(Calendar.getInstance().getTime());
		System.out.println(TimeUtils.dateToString(Calendar.getInstance().getTime()));
	}
	
}
