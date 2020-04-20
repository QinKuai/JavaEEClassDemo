package com.qinkuai.webservice.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HomeworkControllerAspect {
	@Pointcut("execution(** com.qinkuai.webservice.service.HomeworkController.*(..))")
	public void homework() {}
	
	@Before("homework()")
	public void load() {
		System.out.println("Method In HomeworkController.class Start!");
	}
	
	@AfterReturning("homework()")
	public void end() {
		System.out.println("Method In HomeworkController.class End!");
	}
}
