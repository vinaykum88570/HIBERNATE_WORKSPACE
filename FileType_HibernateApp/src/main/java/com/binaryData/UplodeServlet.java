package com.binaryData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet("/UplodeServlet")
@MultipartConfig
public class UplodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Part filePart = request.getPart("file");
		String fileName = filePart.getSubmittedFileName();
		String fileType = filePart.getContentType();
		
//		System.out.println("Mime Part =>"+fileType);
//		
//		InputStream inputStream = filePart.getInputStream();
//		byte[] data = inputStream.readAllBytes();
//		
//		FileEntity fileEntity = new FileEntity(fileName, fileType, data);
//		System.out.println(" ");
//		
//		Session session = HibernateUtil.getsessionFactory().openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(fileEntity);
		
		
		Session session = HibernateUtil.getsessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		FileEntity fileEntity = session.get(FileEntity.class, fileName);
		System.out.println(fileEntity.getFieName()+" "+fileEntity.getFiteType()+""+fileEntity.getData());
		

		response.getWriter().print(fileEntity.getData());
		tx.commit();
		
		
		
		
		
		
		
	}

}
