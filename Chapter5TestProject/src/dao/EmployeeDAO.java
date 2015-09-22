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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

import org.apache.derby.client.am.SqlException;

public class EmployeeDAO implements IEmployee {
	
	
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
	
	@Override
	public List<Employee> selectEmployeesByDepartment(String departmentCode) {
		//List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT ID, FIRSTNAME, LASTNAME, DEPARTMENT_CODE, TITLE FROM EMPLOYEE WHERE DEPARTMENT_CODE = ?";
		
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
		
		List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put(departmentCode, "String");
		params.add(param);
		
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>)executeQuery(sql, processor, new ArrayList<Employee>(),  params);
		
		return employees;
	}


	@Override
	public Employee selectEmployeeByID(int employeeID) {
		String sql = "SELECT ID, FIRSTNAME, LASTNAME, DEPARTMENT_CODE, TITLE FROM EMPLOYEE WHERE ID = ?";
		IResultProcessor processor = new IResultProcessor() {			

			public Object process(ResultSet rs, Object result) throws Exception{
				Employee emp = new Employee();
				emp.setEmployeeID(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setDepartmentCode(rs.getString(4));
				emp.setTitle(rs.getString(5));
				return emp;				
			}
		};
		
		List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> param = new HashMap<String, String>();
		param.put(Integer.toString(employeeID), "int");
		params.add(param);
		
		//System.out.println(params.size());
		
		Employee employee = (Employee)executeQuery(sql, processor, new ArrayList<Employee>(),  params);
		
		return employee;
	}
	
	private Object executeQuery(String sql, IResultProcessor processor, Object result, List<HashMap<String, String>> params){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			//jdbc code here
			String url = "jdbc:derby://localhost:1527/java";
			conn = DriverManager.getConnection(url);
						
			ps = conn.prepareStatement(sql);
			
			if(params != null){
				for(int i = 0; i < params.size(); i++){
					HashMap<String, String> param = params.get(i);
					String val = (String) param.keySet().toArray()[0];
					String valType = param.get(val);
					
					//System.out.println(val + " " + valType);
					
					switch(valType){
					case "String":
						ps.setString(i + 1, val);
						break;
					case "int":
						ps.setInt(i + 1, Integer.parseInt(val));
						break;
					}				
				}					
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				result = processor.process(rs, result);
			}
			
		} catch(Exception sqle) {
			
			sqle.printStackTrace();
			
		} finally {
				
			try{
				if(rs != null){ rs.close(); rs = null;}
				if(ps != null){ ps.close(); ps = null;}
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


	
	

	
}
