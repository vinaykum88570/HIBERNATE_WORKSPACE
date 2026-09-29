package com.password_Encription;

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

@WebServlet("/password")
public class DemoPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("gmail");
		String password = request.getParameter("pwd");
		
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		System.out.println("email ->"+email+" password-> "+password);
		
		String gensalt = BCrypt.gensalt();
		System.out.println("gensalt"+ gensalt);
		
		String hashpw = BCrypt.hashpw(password, gensalt);
		System.out.println("hashpw"+hashpw);
		
		Employee emp = new Employee(email, hashpw);
		System.out.println("email ->"+email+" password-> "+password);

		
		
		
	}

}
