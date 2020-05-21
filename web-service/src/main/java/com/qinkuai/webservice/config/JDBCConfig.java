package com.qinkuai.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qinkuai.db.dao.CourseSelectionDao;
import com.qinkuai.db.dao.HomeworkDao;
import com.qinkuai.db.dao.StudentDao;
import com.qinkuai.db.dao.TaskDao;

/**
 * 
 * @author QinKuai
 * 创建时间：2020年4月6日
 * 描述：DAO层Bean配置
 * 		等价于之前的XML配置模式
 */
@Configuration
public class JDBCConfig {
	@Bean
	public StudentDao getStudentDao() {
		return StudentDao.getInstance();
	}
	
	@Bean
	public HomeworkDao getHomeworkDao() {
		return HomeworkDao.getInstance();
	}
	
	@Bean
	public TaskDao geTaskDao() {
		return TaskDao.getInstance();
	}
	
	@Bean
	public CourseSelectionDao getCourseSelectionDao() {
		return CourseSelectionDao.getInstance();
	}
}
