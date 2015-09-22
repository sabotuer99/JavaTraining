package presentation;



import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import models.Employee;
import bll.EmployeeBLL;

public class StartUp {

	public static void main(String[] args){	
		
		EmployeeBLL employeeBLL = new EmployeeBLL();
		
		int employeeCount = employeeBLL.selectEmployeeCount();
		
		System.out.println("The Employee table has " + employeeCount + " rows.");
		
		Scanner s = new Scanner(System.in);
		try{
			String input = "";
			while(input != "quit" && input != "exit"){
				System.out.print("Enter an Employee ID: ");
				input = s.nextLine();
				
				Employee emp = employeeBLL.selectEmployeeByID(Integer.parseInt(input));
				
				//System.out.println("All employees in Sales and Marketing");
				//for(Employee emp : empsSM){
				
				if(emp == null){
					System.out.println("Employee Not Found!");
				} else {
				
					System.out.println(emp.getEmployeeID() + " : " + 
							emp.getFirstName() + " " + 
							emp.getLastName() + " " + 
							emp.getDepartmentCode() + " " + 
							emp.getTitle());
				}
				
				System.out.print("Press [Enter] to continue...");
				s.nextLine();
				for (int i = 0; i < 50; ++i) System.out.println();
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
	}
}
