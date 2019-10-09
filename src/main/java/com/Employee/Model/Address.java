package com.Employee.Model;

public class Address {
	
	private Integer id;
	private String CityName;
	private String StateName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getStateName() {
		return StateName;
	}
	public void setStateName(String stateName) {
		StateName = stateName;
	}
	public Address(Integer id, String cityName, String stateName) {
		super();
		this.id = id;
		CityName = cityName;
		StateName = stateName;
	}
	
	public Address() {
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", CityName=" + CityName + ", StateName=" + StateName + "]";
	}
	

}
