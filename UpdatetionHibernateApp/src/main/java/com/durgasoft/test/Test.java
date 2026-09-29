package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;
import com.durgasoft.pojo.HibernateUtil;

public class Test {
   public static void main(String[] args) {
	  
	 try {
		 SessionFactory sessionFactory = HibernateUtil.getsessionFactory();   
		 Session session = sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 
			Employee emp1 = new Employee(1, "oooooo", 00000, "ooooooo");
			session.saveOrUpdate(emp1);
			tx.commit();
			
			
		}
	 catch (Exception e) {
		e.printStackTrace();
		
	 }
	 
	 }
	
}
