package com.Employee.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="emp_table")
public class Employee {
	
	@Id
	private int eno;
	private String ename;
	private float esal;
	private String eadrr;
	
	public Employee() {
		
	}
	
	public Employee(int eno, String ename, float esal, String eadrr) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.eadrr = eadrr;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public String getEadrr() {
		return eadrr;
	}
	public void setEadrr(String eadrr) {
		this.eadrr = eadrr;
	}
	
	
}
