package com.durgasoft.pojo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	
	public static SessionFactory getsessionFactory() {

		Configuration config = new Configuration();
		
		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://@localhost:3306/Vinay");
		config.setProperty("hibernate.connection.username", "root");
		config.setProperty("hibernate.connection.password", "root");
		
		config.setProperty("hibernate.Dialect", "org.hibernate.dialect.MySQL8Dialect");
		config.setProperty("hibernate.hbm2ddl.auto", "update");
		config.setProperty("show_sql", "true");
		
		config.addAnnotatedClass(com.durgasoft.pojo.Employee.class);
		
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		return sessionFactory;
	}
	
	
	
}
