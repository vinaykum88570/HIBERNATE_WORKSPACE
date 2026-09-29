package com.Employee.dao;

import com.Employee.pojo.Employee;

public interface EmployeeDao {
		
	public String addEmployee(Employee emp);
	public Employee searchEmployee(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int eno);
	
	
	
}
