package com.entity;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory getsessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://@localhost:3306/vinay");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "root");
		
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect");
		cfg.setProperty("hibernate.hbm2ddl.auto", "update");
		cfg.setProperty("hibernate.show_sql", "true");
		
		cfg.addAnnotatedClass(com.entity.Student.class);
		cfg.addAnnotatedClass(com.entity.StudentDetails.class);
	
		
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
	}
}
