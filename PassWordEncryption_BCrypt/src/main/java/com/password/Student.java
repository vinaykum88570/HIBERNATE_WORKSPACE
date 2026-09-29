package com.password;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stu_password_Encrypt")
public class Student {

	
	
	@Id
	private String email; 
	private String pwd;
	private String uname;
	
	
	public Student(String uname, String email, String pwd) {
		super();
		this.uname = uname;
		this.email = email;
		this.pwd = pwd;
	}

	public Student() {
		
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Student [uname=" + uname + ", email=" + email + ", pwd=" + pwd + "]";
	} 
	
	
}
