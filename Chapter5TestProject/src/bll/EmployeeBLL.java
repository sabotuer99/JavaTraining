package bll;

//import java.sql.SQLException;
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

	@Override
	public List<Employee> selectEmployeesByDepartment(String departmentCode) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		List<Employee> employees = employeeDAO.selectEmployeesByDepartment(departmentCode);
		//List<Employee> employees = employeeDAO.selectAllproc();
		
		return employees;
	}

	@Override
	public Employee selectEmployeeByID(int employeeID) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		Employee employee = employeeDAO.selectEmployeeByID(employeeID);
		//List<Employee> employees = employeeDAO.selectAllproc();
		
		return employee;
	}

	@Override
	public int insertNewEmployee(Employee emp) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		int rows = employeeDAO.insertNewEmployee(emp);
		//List<Employee> employees = employeeDAO.selectAllproc();
		
		return rows;
	}

}
