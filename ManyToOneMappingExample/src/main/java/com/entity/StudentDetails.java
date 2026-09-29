package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {

	@Id
	private int id;
	private String courseName;
	private String collage;
	
	@OneToOne(mappedBy = "studentDetails", cascade = CascadeType.ALL)
	Student stu;
	
	public StudentDetails() {
		
	}
	
	public StudentDetails(int id, String courseName, String collage) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.collage = collage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	@Override
	public String toString() {
		return "id=" + id + ", courseName=" + courseName + ", collage=" + collage + "]";
	}
	
	
	
}
