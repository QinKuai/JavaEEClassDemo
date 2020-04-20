package com.qinkuai.webservice.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CourseControllerAspect {
	@Pointcut("execution(** com.qinkuai.webservice.service.CourseController.*(..))")
	public void course() {}
	
	@Before("course()")
	public void load() {
		System.out.println("Method In CourseController.class Start!");
	}
	
	@AfterReturning("course()")
	public void end() {
		System.out.println("Method In CourseController.class End!");
	}
}
