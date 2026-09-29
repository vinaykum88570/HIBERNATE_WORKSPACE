	package com.Employee.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Employee.factory.HibernateUtil;
import com.Employee.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	String status ="";
	Employee emp = null;
	@Override
	public String addEmployee(Employee employee) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			emp =(Employee) session.get(Employee.class, employee.getEno());
			if(emp == null) {
				Transaction tx = session.beginTransaction();
				session.save(employee);
				tx.commit();
				status="success";
			}
			else {
				status="existed";
			}
		}catch(Exception e){
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		Employee emp = null;
		try {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		emp = (Employee)session.get(Employee.class, eno);
		}catch(Exception e){
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(emp);
			tx.commit();
			status = "success";
			
		}catch(Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteEmployee(int eno) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEno(eno);
			session.delete(employee);
			tx.commit();
			status="success";
		}catch(Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
