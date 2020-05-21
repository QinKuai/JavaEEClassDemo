package com.qinkuai.web.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
@Scope("prototype")
public class TransactionUtil {
	private TransactionStatus transactionStatus;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	public void begin() {
		System.out.println("手动启动事务......");
		transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
	}
	
	public void commit() {
		if(transactionStatus != null) {
			System.out.println("事务提交！");
			transactionManager.commit(transactionStatus);
		}
	}
	
	public void rollback() {
		if(transactionStatus != null) {
			System.out.println("事务回滚");
			transactionManager.rollback(transactionStatus);
		}
	}
}
