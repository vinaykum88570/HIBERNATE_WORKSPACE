package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session s = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
		    sf = cfg.buildSessionFactory();
			s = sf.openSession();
			Employee emp = (Employee)s.get(Employee.class,888);
			if(emp == null) {
				System.out.println("Employee Not Exited");
			}else {
				System.out.println("Employee details:");
				System.out.println("-------------------------");
				System.out.println("Employee Number :"+ emp.getEno());
				System.out.println("Employee Name   :"+ emp.getEname());
				System.out.println("Employee Salary :"+ emp.getEsal());
				System.out.println("Employee Address:"+emp.getEadrr());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			sf.close();
			s.close();
		}
	}
}
