package bll;

import java.sql.SQLException;
import java.util.List;

import models.Employee;
import contracts.IEmployee;
import dao.EmployeeDAO;

public class EmployeeBLL implements IEmployee {

	@Override
	public List<Employee> selectAllEmployees() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		List<Employee> employees = employeeDAO.selectAllEmployees();
		//List<Employee> employees = employeeDAO.selectAllproc();
		
		return employees;
	}

	@Override
	public int selectEmployeeCount(){
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		int employeeCount = employeeDAO.selectEmployeeCount();
		
		return employeeCount;
	}

}
