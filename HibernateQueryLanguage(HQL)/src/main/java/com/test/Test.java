package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Employee;

import jakarta.persistence.Query;

public class Test {

	
	
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
/* 	   Retrive List Of multiple records	
	    Query query = session.createQuery("from Employee");
	    List list = query.getResultList();
	    for(Object obj : list) {
	    	System.out.println(obj); }
*/	    
		
		
/*      Update multiple records
	    Query query = session.createQuery("update Employee s set s.eaddr='Udgir' where s.eaddr='Kalka'");
	    int modifiedRecords = query.executeUpdate();
        System.out.println(modifiedRecords+" Row updated successfully");
*/  
	
		
/*   Delete multiple records
	 Query query =session.createQuery("delete Employee stu where stu.id=7");
	 int modifiedRecords = query.executeUpdate();
     System.out.println(modifiedRecords +" Modified records");
*/		
		
		 
		
		
	}
	    
}

