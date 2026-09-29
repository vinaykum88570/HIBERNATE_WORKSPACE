package com.map.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="e_tbl") 
public class Employee {

	@Id
	private int emp_Id;
	private String emp_Name;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="emp_o",
	joinColumns = @JoinColumn(name="emp_Id"),
	inverseJoinColumns = @JoinColumn(name="o_Id")
	)
	List<Orders> order;
	
	
	public Employee() {
		
	}


	public Employee(int emp_Id, String emp_Name) {
		super();
		this.emp_Id = emp_Id;
		this.emp_Name = emp_Name;
	}


	public int getEmp_Id() {
		return emp_Id;
	}


	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}


	public String getEmp_Name() {
		return emp_Name;
	}


	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}


	public List<Orders> getOrder() {
		return order;
	}


	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	
	
}
