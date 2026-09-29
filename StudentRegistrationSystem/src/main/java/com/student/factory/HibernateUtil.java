package com.student.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	static {
		
	Configuration configuration = new Configuration();
	configuration.configure();
	sessionFactory = configuration.buildSessionFactory();
	
	}
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	public static void cleanUp() {
		
		sessionFactory.close();
	}
}
