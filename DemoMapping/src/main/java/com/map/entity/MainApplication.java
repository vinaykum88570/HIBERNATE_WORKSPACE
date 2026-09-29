package com.map.entity;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainApplication {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtlil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Employee aaa = new Employee(1, "AAA");
		Employee bbb = new Employee(2, "BBB");
		Employee ccc = new Employee(3, "CCC");
		
		ArrayList<Employee> arrayList = new ArrayList<Employee>();
		arrayList.add(aaa);
		arrayList.add(bbb);
		arrayList.add(ccc);
		
		session.save(aaa);
		session.save(bbb);
		session.save(ccc);
		
		
		Orders order1 = new Orders(101, "Tango");
		Orders order2 = new Orders(102, "Mango");
		Orders order3 = new Orders(103, "Vango");
		
		order1.setEmployee(arrayList);
		order2.setEmployee(arrayList);
		order3.setEmployee(arrayList);
		
		session.save(order1);
		session.save(order2);
		session.save(order3);
		
		tx.commit();
		System.out.println("successfull task");
	}
}
