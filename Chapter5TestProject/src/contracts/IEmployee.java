package contracts;

import java.sql.SQLException;

import org.apache.derby.client.am.SqlException;

import models.Employee;


public interface IEmployee {
	int selectEmployeeCount();
}
