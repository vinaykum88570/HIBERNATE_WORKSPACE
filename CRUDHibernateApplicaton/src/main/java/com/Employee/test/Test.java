package com.Employee.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.Employee.dao.EmployeeDao;
import com.Employee.factory.EmployeeDaoFactory;
import com.Employee.factory.HibernateUtil;
import com.Employee.pojo.Employee;

public class Test {

	public static void main(String[] args) {
			
		BufferedReader br = null;
		String status="";
		try {
			EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
			br = new BufferedReader(new InputStreamReader(System.in));
			Employee emp = new Employee();
			while(true) {
				System.out.println();
				System.out.println("1.Add Employee");
				System.out.println("2.Serach Employee");
				System.out.println("3.Update Employee");
				System.out.println("4.Delete Employee");
				System.out.println("5.Exit");
				System.out.println("choose u r Option ");
				int option = Integer.parseInt(br.readLine());
				
				int eno=0;
				String ename="";
				float esal=0.0f;
				String eadr ="";
				switch(option){
				
				case 1:
					System.out.println("------ Add Employee Module -------");
					System.out.println("Employee Number :");
				    eno = Integer.parseInt(br.readLine());
					System.out.println("Employee Name :");
					ename = br.readLine();
					System.out.println("Employee Salary :");
				    esal = Float.parseFloat(br.readLine());
					System.out.println("Employee Address :");
					String eadrr = br.readLine();
					
					emp = new Employee(eno, ename, esal, eadrr);
					status = dao.addEmployee(emp);
					if(status.equals("success")) {
						 System.out.println("Employee Insertion success");
					}
					if(status.equals("failure")) {
						System.out.println("Employee Insertion failure");
					}
					if(status.equals("Existed")) {
						System.out.println("Employee Already Existed");
					}
					break;
				
				case 2:
					System.out.println("------- Search Employee Module ------");
					System.out.println("Employee Number ");
					eno = Integer.parseInt(br.readLine());
					emp = dao.searchEmployee(eno);	
					if(emp==null) {
						System.out.println("Employee not Existed");
					}else {
						System.out.println("Employee Details");
						System.out.println("--------------------");
						System.out.println("Employee Number:"+ emp.getEno());
						System.out.println("Employee Name:"+ emp.getEname());
						System.out.println("Employee Salary:"+ emp.getEsal());
						System.out.println("Employee Address:"+ emp.getEadrr());
						
					}
					break;
					
				case 3:
					System.out.println("------- Employee update Module-----");
					System.out.println("Employee Number ");
					eno = Integer.parseInt(br.readLine());
					emp = dao.searchEmployee(eno);	
					if(emp==null) {
						System.out.println("Employee not Existed");
					}else {
						System.out.println("Enter New Employee Details");
						System.out.println("ENO"+ emp.getEno());
						System.out.print("ENAME Old Value:"+ emp.getEname()+", New Value: ");
						String empName=br.readLine();
						System.out.print("ESAL Old Vlaue:"+ emp.getEsal()+", New Value: ");
						String empSal=br.readLine();
						System.out.print("EADRR Old Value :"+ emp.getEadrr()+" New Value :");
						String empAdrr=br.readLine();
						
						Employee employee = new Employee();
						employee.setEno(eno);
						
						if(empName == null || empName.equals("")) {
							employee.setEname(emp.getEname());
						}else {
							employee.setEname(empName);
						}
						
						if(empSal == null ||empName.equals("")) {
							employee.setEsal(emp.getEsal());
						}else {
							employee.setEsal(Float.parseFloat(empSal));
						}
						
						if(empAdrr == null || empAdrr.equals("")) {
							employee.setEadrr(emp.getEadrr());
						}else {
							employee.setEadrr(empAdrr);
						}
						
						status = dao.updateEmployee(employee);
						if(status.equals("success")){
							System.out.println("Employee Updates Succesfully");
						}
						if(status.equals("failure")) {
							System.out.println("Employee updation failure");
						}
					}
					   break;
					
				case 4:
					System.out.println("------- Search Delete Module ------");
					System.out.println("Employee Number ");
					eno = Integer.parseInt(br.readLine());
					emp = dao.searchEmployee(eno);	
					if(emp==null) {
						System.out.println("Employee not Existed");
					}else {
						status = dao.deleteEmployee(eno);
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
					   System.out.println("Enter The numer betwee 1, 2 , 3, 4 and 5.");
					   break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
