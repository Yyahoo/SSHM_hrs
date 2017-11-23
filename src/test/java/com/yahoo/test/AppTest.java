package com.yahoo.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class AppTest {
	
	@Test
	public void TestSave() {
		Session session=new Configuration().configure().buildSessionFactory().getCurrentSession();
		
	}
	

}
