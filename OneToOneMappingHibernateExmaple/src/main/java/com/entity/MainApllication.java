package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MainApllication {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student student = new Student(1, "Suraj");
		StudentDetails stuDetails = new StudentDetails(101, "BSC", "Mumu");
		 
		student.setStudentDetails(stuDetails); 
//		stuDetails.setStu(student);
		session.save(student);
		
		
		tx.commit();
		
//		StudentDetails studentDetails = session.get(StudentDetails.class, 102);
//		System.out.println(studentDetails);
//		Student stu = studentDetails.getStu();
//		System.out.println(stu);
	}

}
