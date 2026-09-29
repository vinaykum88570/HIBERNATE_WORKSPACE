package com.password;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/StudentServlets")
public class StudentServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		System.out.println("Password "+ pwd);
		
		// BCrypt 
		String gensalt = BCrypt.gensalt();
		System.out.println("Password "+gensalt);
		
		System.out.println("Password ->"+pwd+" gensalt-> "+gensalt);
		
		String hashpw = BCrypt.hashpw(pwd, gensalt);
		System.out.println("Password "+ hashpw);
		
		System.out.println("Password ->"+pwd+" gensalt-> "+gensalt);
		
		Student stu = new Student(uname, email, hashpw);
		System.out.println(stu);
		
		System.out.println();
		
//		SessionFactory sessionFactory = HibernateUtil.getsessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(stu);
//		
//		System.out.println("Inserted Done");
//		tx.commit();

		
		
	}

}
