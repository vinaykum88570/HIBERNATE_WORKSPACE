package com.manytomany.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_table")
public class Employee {

	@Id
	int employee_ID;
	String employee_Name;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="emp_pro",
	           joinColumns = @JoinColumn(name="employee_ID"),
	           inverseJoinColumns = @JoinColumn(name="project_ID"))
	List<Projects> projects;

	public Employee() {
		
	}
	
	public Employee(int employee_ID, String employee_Name) {
		super();
		this.employee_ID = employee_ID;
		this.employee_Name = employee_Name;
	}

    public int getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(int employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getEmployee_Name() {
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	
	
	
}
