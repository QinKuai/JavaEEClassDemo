package com.qinkuai.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qinkuai.web.transaction.TransactionUtil;

@Component
@Aspect
public class TransactionAspect {
	@Autowired(required = false)
	private TransactionUtil transactionUtil;
	
	@Pointcut("execution(** com.qinkuai.web.controller..*.*(..))")
	public void addTransaction() {}
	
	@AfterThrowing("addTransaction()")
	public void rollback() {
		transactionUtil.rollback();
	}
	
	@Around("addTransaction()")
	public Object around(ProceedingJoinPoint joingPoint) throws Throwable{
		transactionUtil.begin();
		Object object = joingPoint.proceed();
		transactionUtil.commit();
		return object;
	}
}
