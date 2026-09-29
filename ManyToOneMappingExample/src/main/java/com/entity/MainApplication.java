package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApplication {

	public static void main(String[] args) {
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
	/*	Order ord1 = new Order(504, "c", 555);
		Order ord2 = new Order(505, "python", 655);
		Order ord3 = new Order(506, "Spring", 100);
		Student stu = session.get(Student.class, 2);
		ord1.setSid(stu);
		ord2.setSid(stu);
		ord3.setSid(stu);
		session.save(ord1);
		session.save(ord2);
    	session.save(ord3);
    	
    */	
	  	
		
	/*	Student std = session.get(Student.class, 1);
		List<Order> orders = std.orders;
		for(Order o: orders )
		{
			System.out.println(o);
		}
	*/	
	
		Order o1 = session.get(Order.class, 504);
		session.delete(o1);
	
	
		
		tx.commit();
		
		
		
	}

}
