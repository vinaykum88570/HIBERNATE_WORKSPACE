package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApplication {

	public static void main(String[] args) {
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
       
        
        Items i1 = new Items(103, "Asus");
        Items i2 = new Items(104,"Redme");
        
        Student student = new Student(1, "AAA");
        
        i1.setStudent(student);
        i2.setStudent(student);
        
        session.save(i1);
        session.save(i2);
        
        tx.commit();
        
       
		
		
		
		
	}

}
