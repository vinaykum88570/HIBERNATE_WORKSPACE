package com.main;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet("/login")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("uname");
		String s2 = request.getParameter("pwd");
		
		System.out.println(s1+" "+s2);
		
	SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
	Session session = sessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	
	User user = new User(s1, s2);
	session.save(user);
	tx.commit();
	
	PrintWriter pw = response.getWriter();
	pw.print("Succesfully Inserted !");
	
	}

}
