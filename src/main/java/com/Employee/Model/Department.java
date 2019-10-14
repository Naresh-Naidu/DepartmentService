package com.Employee.Model;

public class Department {
	
	private String id;
	private String deptName;
	private String deptLocation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}
	public Department(String id, String deptName, String deptLocation) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}
	
	
	public Department() {
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", deptLocation=" + deptLocation + "]";
	}

	
}
