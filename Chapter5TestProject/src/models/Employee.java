package models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	private int employeeID;
	private String firstName;
	private String lastName;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
