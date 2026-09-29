package com.student.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.dao.StudentDao;
import com.student.entity.Student;
import com.student.factory.HibernateUtil;
import com.student.factory.StudentDaoFactory;

public class MainController {

	public static void main(String[] args) {
		BufferedReader br =  null;
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			Student stu = new Student();
			StudentDao dao = StudentDaoFactory.getStudentDao();
			while(true) {
				  System.out.println();
					System.out.println("1.Add Student");
					System.out.println("2.Serach Student");
					System.out.println("3.Update Student");
					System.out.println("4.Delete Student");
					System.out.println("5.Exit");
					System.out.println("choose u r Option 1 to 5");
					
					int option =Integer.parseInt(br.readLine()) ;
					
					String status="";
					int id;
					String fname;
					String lname;
					String age;
					String email;
					String MobNo;
					String location;
					switch (option) {			
					case 1:
						System.out.println("----- Add Module-----");
						System.out.println("Enter First Name");
						fname = br.readLine();
						System.out.println("Enter Last Name");
						lname = br.readLine();
						System.out.println("Enter Age");
						age = br.readLine();
						System.out.println("Enter Email ");
						email = br.readLine();
						System.out.println("Enter MobNo");
						MobNo = br.readLine();
						System.out.println("Enter Location");
						location = br.readLine();
						stu = new Student(fname, lname, age, email, MobNo, location);
						status = dao.addStudent(stu);
						if(status=="success") {
							System.out.println("Student Insertion SUCCESS Your Id is ==> " + stu.getId());
						}
						if(status=="failure") {
							System.out.println("Student Insertion FAIL");
						}
						if(status=="Existed") {
							System.out.println("Student Already EXISTED");
						}
						
						break;
						
                    case 2:  
                    	System.out.println("----- Search Module-----");
						System.out.println("Enter Your Id");
						id = Integer.parseInt(br.readLine());
						stu = dao.searchStudent(id);
						if(stu==null) {
							System.out.println("Student Not Existed");
						}else {
							System.out.println("Student Details");
							System.out.println("--------------------");
							System.out.println("Student Id: "+ stu.getId());
							System.out.println("Student Name: "+ stu.getfName()+" "+ stu.getlName());
							System.out.println("Student Age: "+ stu.getAge() );
							System.out.println("Student Email: "+ stu.getEmail());
							System.out.println("Student MobNo: "+ stu.getMobNo());
							System.out.println("Student Location: "+ stu.getLocation());
							
						}
						break;
						
                    case 3:
                    	System.out.println("------ Update Module -----");
                    	System.out.println("Enter Your Id");
						id = Integer.parseInt(br.readLine());
						stu = dao.searchStudent(id); //1
						if(stu==null) { 
							System.out.println("Student Not Existed");
						}
						else {
							System.out.println("Enter New Student Details");
							System.out.println("--------------------");
							System.out.println("Student Id: "+ stu.getId());//1
							System.out.print("FirstName Old Value: "+ stu.getfName()+" ||   New Value: ");
						    String stuFname=br.readLine();
							System.out.print("LastName Old Value: "+ stu.getlName()+" ||   New Value: ");
							String stuLname=br.readLine();
							System.out.print("Age Old Value: "+ stu.getAge()+" ||   New Value: " );
							String stuAge=br.readLine();
							System.out.print("Email Old Value: "+ stu.getEmail()+" ||   New Value: ");
							String stuEmail=br.readLine();
							System.out.print("MobNo Old Value: "+ stu.getMobNo()+" ||   New Value: ");
							String stuMobNo=br.readLine();
							System.out.print("Location Old Value: "+ stu.getLocation()+" ||   New Value: ");
							String stuLocation=br.readLine();
                    	
							Student student = new Student();
							student.setId(id);
							
							if(stuFname == null || stuFname.equals("")) { 
								student.setfName(stu.getfName());
//								System.out.println("stuFname==> "+stu.getfName());
//								System.out.println("stuFname==> "+stuFname);
							}else {
								student.setfName(stuFname);// 
//								System.out.println("stuFname==> "+stuFname);
							}
							
							if(stuLname==null || stuLname.equals("")) {
								student.setlName(stu.getlName());
//								System.out.println("stuLname==> "+stu.getlName());
//								System.out.println("stuLname==> "+stuLname);
							}else {
								student.setlName(stuLname);
//								System.out.println("stuLname==> "+stuLname);
							}
							
							if(stuAge==null || stuAge.equals("")) {
								student.setAge(stu.getAge());
//								System.out.println("stuAge==> "+stu.getAge());
//								System.out.println("stuAge==> "+stuAge);
							}else {
								student.setAge(stuAge);
//								System.out.println("stuAge==> "+stuAge);
							}
                    	
							if(stuEmail==null || stuEmail.equals("")) {
								student.setEmail(stu.getEmail());
//								System.out.println("stuEmail==> "+stu.getEmail());
//								System.out.println("stuEmail==> "+stuEmail);
							}else {
								student.setEmail(stuEmail);
//								System.out.println("stuEmail==> "+stuEmail);
							}
							
							if(stuMobNo==null || stuMobNo.equals("")) {
								student.setMobNo(stu.getMobNo());
//								System.out.println("stuMobNo==> "+stu.getMobNo());
//								System.out.println("stuMobNo==> "+stuMobNo);
							}
							else {
								student.setMobNo(stuMobNo);		
//								System.out.println("stuMobNo==> "+stuMobNo);
							}
						
					       if(stuLocation==null|| stuLocation.equals("")) {
					    	   student.setLocation(stu.getLocation());	 
//					    	   System.out.println("stuLocation==> "+stu.getLocation());
//					    	   System.out.println("stuLocation==> "+stuLocation);
					      }
					       else {
					    	  student.setLocation(stuLocation);
//					    	  System.out.println("stuLocation==> "+stuLocation);
					      }
					       
					       status = dao.updateStudent(student);
					       if(status.equals("success")) {
					    	   System.out.println("Student Updates Succesfully");
					       }
					       if(status.equals("failure")) {
					    	   System.out.println("Employee updation failure"); 
					       }
						}
					       break;

                    case 4:
                    	System.out.println("------ Delete Module ------");
                    	System.out.print("Enter Your id");
                    	id = Integer.parseInt(br.readLine());
                    	stu=dao.searchStudent(id);
                    	if(stu==null) {
                    		System.out.println("Student Not Existed");
                    	}else {
                    		status = dao.deleteStudent(id);
                    		if(status.equals("success")) {
    							System.out.println("Emoployee deleted successfully");
    						}
    						if(status.equals("failure")) {
    							System.out.println("Emoployee deleted failure");
    						}
                    	}
                    	break;
                    	
                    case 5:
                      System.out.println("******* Thank you using this Application********");
  					   HibernateUtil.cleanUp();
  					   System.exit(0);
                    	break;
                    	
					default:
						 System.out.println("Enter The number between 1, 2, 3, 4 and 5.");
						 
						break;
					}
			  }
		}catch (Exception e) {
			e.printStackTrace();
		}
	  
	  
	}

}
 