package presentation;

import bll.EmployeeBLL;

public class StartUp {

	public static void main(String[] args){	
		
		EmployeeBLL employeeBLL = new EmployeeBLL();
		
		int employeeCount = employeeBLL.selectEmployeeCount();
		
		System.out.println("The Employee table has " + employeeCount + " rows.");
		
	}
}
