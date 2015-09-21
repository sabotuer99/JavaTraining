package dao;

import models.Employee;
import contracts.IEmployee;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.*;

import java.util.ArrayList;

import org.apache.derby.client.am.SqlException;

public class EmployeeDAO implements IEmployee {
	
	public int selectEmployeeCount(){
		
		int employeeRowCount = 0;
		
		String URL = "jdbc:derby://localhost:1527/java";
		
		
		try{
			//jdbc code here
			
			Connection conn = DriverManager.getConnection(URL);
			Statement stmt = conn.createStatement();
			String sqltxt = "SELECT COUNT(*) FROM EMPLOYEE";
			ResultSet rs = stmt.executeQuery(sqltxt);
			employeeRowCount = rs.getInt(1);
			
		} catch(SQLException sqle) {
			
			System.err.println("error");
			
		} finally {
			
			//clean up here
			
		}

		
		//Select Count(*) from Employee
		
		return employeeRowCount;
	}
	
}
