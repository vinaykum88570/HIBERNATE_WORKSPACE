package com.durgasoft.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stu_table")
public class Employee {
	private int eno;
	private String ename;
	private float esal;
	private String eadrr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
