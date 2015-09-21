package contracts;

import java.sql.SQLException;
import java.util.List;

import org.apache.derby.client.am.SqlException;

import models.Employee;


public interface IEmployee {
	int selectEmployeeCount();
	
	//SELECT FIRSTNAME, LASTNAME, ID
	List<Employee> selectAllEmployees();
}
