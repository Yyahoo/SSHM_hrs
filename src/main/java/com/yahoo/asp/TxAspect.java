package com.yahoo.asp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TxAspect {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Around("execution(* com.yahoo.service.impl.*.*(..))")
	public Object doTransaction(ProceedingJoinPoint jp) throws Throwable {
		Session session=sessionFactory.getCurrentSession();
		Object retVal=null;
		try {
			session.beginTransaction();
			retVal=jp.proceed(jp.getArgs());
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return retVal;
	}
	

}
