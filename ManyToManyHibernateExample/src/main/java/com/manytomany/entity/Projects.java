package com.manytomany.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects_table")
public class Projects {
	
    @Id
	int project_ID;
	String project_Name;
	
	@ManyToMany(mappedBy ="projects")
	List <Employee> employee;
	
	public Projects() {
		
	}

	public Projects(int project_ID, String project_Name) {
		super();
		this.project_ID = project_ID;
		this.project_Name = project_Name;
	}

	public int getProject_ID() {
		return project_ID;
	}

	public void setProject_ID(int project_ID) {
		this.project_ID = project_ID;
	}

	public String getProject_Name() {
		return project_Name;
	}

	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
	
	
	
}
