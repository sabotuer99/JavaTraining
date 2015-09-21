package presentation;



import java.util.List;

import models.Employee;
import bll.EmployeeBLL;

public class StartUp {

	public static void main(String[] args){	
		
		EmployeeBLL employeeBLL = new EmployeeBLL();
		
		int employeeCount = employeeBLL.selectEmployeeCount();
		
		System.out.println("The Employee table has " + employeeCount + " rows.");
		
		List<Employee> emps = employeeBLL.selectAllEmployees();
		
		for(Employee emp : emps){
			System.out.println(emp.getEmployeeID() + " : " + emp.getFirstName() + " " + emp.getLastName());
		}
		
	}
}
