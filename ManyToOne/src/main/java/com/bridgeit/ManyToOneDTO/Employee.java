package com.bridgeit.ManyToOneDTO;

public class Employee {

	private int employeeId;
	private String employeeName;
	private Dept myDept;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Dept getMyDept() {
		return myDept;
	}

	public void setMyDept(Dept myDept) {
		this.myDept = myDept;
	}

}
