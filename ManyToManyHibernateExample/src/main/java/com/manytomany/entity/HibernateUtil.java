package com.manytomany.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getsessionFactory() {
		Configuration config = new Configuration();
		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://@localhost:3306/vinay");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.connection.password", "root");
		
		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		config.setProperty("hibernate.hbm2ddl.auto", "create");
		config.setProperty("show_sql", "true");
		
		config.addAnnotatedClass(com.manytomany.entity.Employee.class);
		config.addAnnotatedClass(com.manytomany.entity.Projects.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		return sessionFactory;
	}
}
