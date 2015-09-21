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
import java.util.List;

import org.apache.derby.client.am.SqlException;

public class EmployeeDAO implements IEmployee {
	
	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try{
			//jdbc code here
			String url = "jdbc:derby://localhost:1527/java";
			conn = DriverManager.getConnection(url);
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM EMPLOYEE"; 
						
			//ps = conn.prepareStatement(sql);
			//rs = ps.executeQuery();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				employees.add(emp);
			}
			
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
			
		} finally {
				
			try{
				if(rs != null){ rs.close(); rs = null;}
				if(ps != null){ ps.close(); ps = null;}
				if(stmt != null){ stmt.close(); stmt = null;}
				if(conn != null && !conn.isClosed()){
					conn.close();
					conn = null;
				}
				
			} catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
			
			
		}
	
		return employees;
	}
	

	public int selectEmployeeCount(){
		
		int employeeCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try{
			//jdbc code here
			String url = "jdbc:derby://localhost:1527/java";
			conn = DriverManager.getConnection(url);
			String sql = "SELECT Count(*) FROM EMPLOYEE"; 
						
			//ps = conn.prepareStatement(sql);
			//rs = ps.executeQuery();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				employeeCount = rs.getInt(1);
			}
			
		} catch(SQLException sqle) {
			
			sqle.printStackTrace();
			
		} finally {
				
			try{
				if(rs != null){ rs.close(); rs = null;}
				if(ps != null){ ps.close(); ps = null;}
				if(stmt != null){ stmt.close(); stmt = null;}
				if(conn != null && !conn.isClosed()){
					conn.close();
					conn = null;
				}
				
			} catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
			
			
		}
	
		return employeeCount;
	}

}
