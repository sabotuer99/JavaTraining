package bll;

import java.sql.SQLException;

import contracts.IEmployee;
import dao.EmployeeDAO;

public class EmployeeBLL implements IEmployee {

	@Override
	public int selectEmployeeCount(){
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		int employeeCount = employeeDAO.selectEmployeeCount();
		
		return employeeCount;
	}

}
