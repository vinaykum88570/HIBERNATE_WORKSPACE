package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="items_table")
public class Items {

	@Id
	private int item_id ;
	private String item_Name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="stu_id")
	Student student;
	
	public Items() {
		
	}

	public Items(int item_id, String item_Name) {
		super();
		this.item_id = item_id;
		this.item_Name = item_Name;
	
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_Name() {
		return item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	

	
}
