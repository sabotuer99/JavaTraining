package dao;

import models.Employee;
import contracts.IEmployee;
import contracts.IResultProcessor;

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
	/*
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
	}*/
	
	/*public int selectEmployeeCount(){
		
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
	}*/
	
	public List<Employee> selectAllEmployees(){
		//List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM EMPLOYEE";
		
		IResultProcessor processor = new IResultProcessor() {			
			@SuppressWarnings("unchecked")
			public Object process(ResultSet rs, Object result) throws Exception{
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				((List<Employee>)result).add(emp);
				return result;				
			}
		};
		
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>)executeQuery(sql, processor, new ArrayList<Employee>() );
		
		return employees;
	}
	
	
	public int selectEmployeeCount(){
		//List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT Count(*) FROM EMPLOYEE";
		
		IResultProcessor processor = new IResultProcessor() {			
			public Object process(ResultSet rs, Object result) throws Exception{
				return rs.getInt(1);			
			}
		};
		
		int employeeCount = (int)executeQuery(sql, processor, null);
		
		return employeeCount;
	}
	
	
	private Object executeQuery(String sql, IResultProcessor processor, Object result, List<String> params){
		//Object result = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//Statement stmt = null;
		
		try{
			//jdbc code here
			String url = "jdbc:derby://localhost:1527/java";
			conn = DriverManager.getConnection(url);
			//String sql = "SELECT Count(*) FROM EMPLOYEE"; 
						
			ps = conn.prepareStatement(sql);
			
			/*
			if(params != null){
				for(String param : params)
					ps.setString(parameterIndex, x);
			}*/
			
			rs = ps.executeQuery();
			//stmt = conn.createStatement();
			//rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				result = processor.process(rs, result);
			}
			
		} catch(Exception sqle) {
			
			sqle.printStackTrace();
			
		} finally {
				
			try{
				if(rs != null){ rs.close(); rs = null;}
				if(ps != null){ ps.close(); ps = null;}
				//if(stmt != null){ stmt.close(); stmt = null;}
				if(conn != null && !conn.isClosed()){
					conn.close();
					conn = null;
				}
				
			} catch(Exception ex) {
				
				ex.printStackTrace();
				
			}
			
			
		}
	
		return result;
	}
	
	private Object executeQuery(String sql, IResultProcessor processor, Object result){
		return executeQuery(sql, processor, result, null);
	}


	
	
	@Override
	public List<Employee> selectEmployeesByDepartment(String departmentCode) {
		//List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT ID, FIRSTNAME, LASTNAME, DEPARTMENT_CODE, TITLE FROM EMPLOYEE WHERE DEPARTMENT_CODE = '" + departmentCode + "'";
		
		IResultProcessor processor = new IResultProcessor() {			
			@SuppressWarnings("unchecked")
			public Object process(ResultSet rs, Object result) throws Exception{
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setDepartmentCode(rs.getString(4));
				emp.setTitle(rs.getString(5));
				((List<Employee>)result).add(emp);
				return result;				
			}
		};
		
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>)executeQuery(sql, processor, new ArrayList<Employee>() );
		
		return employees;
	}
	
}
