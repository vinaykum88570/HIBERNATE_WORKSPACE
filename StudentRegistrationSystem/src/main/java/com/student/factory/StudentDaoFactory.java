package com.student.factory;

import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImplementation;

public class StudentDaoFactory {

	public static StudentDao studentDao;
	static {
		studentDao = new StudentDaoImplementation();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
