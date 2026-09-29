package com.map.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="oo_tbl")
public class Orders {

	@Id
	private int o_Id;
	private String o_Name;
	
	@ManyToMany(mappedBy = "order",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List<Employee> employee;
	
	public Orders() {
		
	}

	@Override
	public String toString() {
		return "Orders [o_Id=" + o_Id + ", o_Name=" + o_Name + "]";
	}

	public Orders(int o_Id, String o_Name) {
		super();
		this.o_Id = o_Id;
		this.o_Name = o_Name;
	
	}

	public int getO_Id() {
		return o_Id;
	}

	public void setO_Id(int o_Id) {
		this.o_Id = o_Id;
	}

	public String getO_Name() {
		return o_Name;
	}

	public void setO_Name(String o_Name) {
		this.o_Name = o_Name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	
	
	
	
	
	
}
