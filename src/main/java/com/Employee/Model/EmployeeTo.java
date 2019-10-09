package com.Employee.Model;

public class EmployeeTo {
	
	private Integer id;
	private String name;
	private String department;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public EmployeeTo(Integer id, String name, String department, String address) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.address = address;
	}
	
	public EmployeeTo() {
		// TODO Auto-generated constructor stub
	}
	

}
