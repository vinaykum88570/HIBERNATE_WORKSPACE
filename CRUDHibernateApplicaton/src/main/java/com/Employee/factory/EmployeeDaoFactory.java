package com.Employee.factory;

import com.Employee.dao.EmployeeDao;
import com.Employee.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
	
	private static EmployeeDao empDao;
	static {
		empDao = new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao() {
		return empDao;
	}
}
