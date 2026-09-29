package com.manytomany.entity;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApplication {

	public static void main(String[] args) {
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		// Employees
		Employee vinay = new Employee(1, "Vinay");
		Employee faisal = new Employee(2, "Faisal");
		
		// Projects
		Projects amazon = new Projects(101, "Amazon");
		Projects flipkark = new Projects(102, "Flipkark");
		
		
		// Make a list of projects
		ArrayList<Projects> al = new ArrayList<Projects>();
		al.add(amazon);
		al.add(flipkark);
		
		session.save(amazon);
		session.save(flipkark);
		
		// Settings Prjects List to the Employee Object
		vinay.setProjects(al);
		faisal.setProjects(al);
		
		session.save(vinay);
		session.save(faisal);
		
		tx.commit();
	
		
		
	}
	

}
