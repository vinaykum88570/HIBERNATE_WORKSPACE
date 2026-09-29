package com.student.dao;

import com.student.entity.Student;


public interface StudentDao {

	public String addStudent(Student stu);
	public Student searchStudent(int id);
	public String updateStudent(Student stu);
	public String deleteStudent(int id);
	
	
}
