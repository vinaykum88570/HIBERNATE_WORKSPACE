package com.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.student.entity.Student;
import com.student.factory.HibernateUtil;

public class StudentDaoImplementation implements StudentDao {

	Student student = null;
	String status ="";
	@Override
	public String addStudent(Student stu) {	
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			student =(Student) session.get(Student.class,stu.getId());
			if(student==null) {
				Transaction tx = session.beginTransaction();
				session.save(stu);
				tx.commit();
				status="success";
			}else {
				status="existed";
			}
		}catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student searchStudent(int id) {
		Student stu = null;
	 try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		stu = (Student)session.get(Student.class,id);
	   }catch (Exception e) {
		  e.printStackTrace();
	   }
		return stu;
	} 

	@Override
	public String updateStudent(Student student) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(student);
			tx.commit();
			status="success";
			
		}catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteStudent(int id) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Student student = new Student();
            student.setId(id);
			session.delete(student);
			tx.commit();
			status = "success";
		}catch(Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		
		return status;
	}
	
	

}
