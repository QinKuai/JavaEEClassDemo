package com.qinkuai.webservice.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaskControllerAspect {
	@Pointcut("execution(** com.qinkuai.webservice.service.TaskController.*(..))")
	public void task() {}
	
	@Before("task()")
	public void load() {
		System.out.println("Method In TaskController.class Start!");
	}
	
	@AfterReturning("task()")
	public void end() {
		System.out.println("Method In TaskController.class End!");
	}
}
