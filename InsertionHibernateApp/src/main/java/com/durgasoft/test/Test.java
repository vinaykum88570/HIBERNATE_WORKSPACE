package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;


public class Test {

	public static void main(String[] args)throws Exception {
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	Employee emp = new Employee(888, "vinay", 1000, "Nanded");
	session.save(emp);
	
//	Employee Emp = session.get(Employee.class, 1);
//	System.out.println(Emp);

	tx.commit();
	System.out.println("Inserted Successfully");
	sf.close();
	session.close();
	
	
	



	}

}
