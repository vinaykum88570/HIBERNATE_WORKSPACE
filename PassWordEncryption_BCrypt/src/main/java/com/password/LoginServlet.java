package com.password;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	
	Session session = HibernateUtil.getsessionFactory().openSession();
	Transaction tx = session.beginTransaction();
	
	Student student =(Student) session.get(Student.class,email);
	
	if(student==null) {
		response.getWriter().print("Wrong Email");
		return;
	}
	
	boolean checkpw = BCrypt.checkpw(pwd, student.getPwd());
	
	if(checkpw == true) {
		response.getWriter().print("Successfull");
	}else {
		response.getWriter().print("Wrong Email or PassWord");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
