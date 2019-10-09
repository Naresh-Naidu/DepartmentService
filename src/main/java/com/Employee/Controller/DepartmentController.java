package com.Employee.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Employee.Model.Convertable;
import com.Employee.Model.Department;
import com.Employee.Model.Employee;
import com.Employee.Model.EmployeeTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DepartmentController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping("getAllDepartment")
	public List<Department> getAllDepartment(){
		return Arrays.asList(
				new Department(11, "IT", "Bangalore"),
				new Department(12, "Admin", "Bangalore"),
				new Department(13, "HR", "Hyderbad")
				);
	}
	
	@GetMapping("getEmployeeBaseOnDept/{deptName}")
	public Convertable getEmployeesBydept(@PathVariable String deptName) {
		System.out.println("ENtered");
		
		//
		List<Department> depts=getAllDepartment();
		List<Department> requiredDepts=new ArrayList<Department>();
		
		
		Integer departmentid=0;
		
		requiredDepts=depts.stream().filter( dept-> dept.getDeptName().equalsIgnoreCase(deptName)).collect(Collectors.toList());
		departmentid=depts.stream().filter( dept-> dept.getDeptName().equalsIgnoreCase(deptName)).map(dep->dep.getId()).findAny().get();
		
		
		String url="http://employee-Service/employeeByDept/"+departmentid;
		ResponseEntity<List<Employee>>  employeeList=template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
		
			int empAddId= !employeeList.getBody().isEmpty()?employeeList.getBody().get(0).getAddressid():0;
		
		ResponseEntity<List<com.Employee.Model.Address>> adddress=template.exchange("http://address-service/addressById/"+empAddId, HttpMethod.GET, null, new ParameterizedTypeReference<List<com.Employee.Model.Address>>() {});
		Convertable con=new Convertable();
		
		
		con.setEmployees(employeeList.getBody());
		con.setDepartments(requiredDepts);
		con.setAddress(adddress.getBody());
		
		HttpEntity<Convertable> object=new HttpEntity<Convertable>(con);
		ObjectMapper mapper=new ObjectMapper();
		String json="";
		try {
			json=mapper.writeValueAsString(con);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		url="http://employee-Service/convert/"+con.toString();
		System.out.println(url);
		ResponseEntity<List<EmployeeTo>> employeeTo=template.exchange(url, HttpMethod.GET, object, new ParameterizedTypeReference<List<EmployeeTo>>() {});
		//List<EmployeeTo> employeeTos= employeeTo.getBody();
		return con;
	}
	
	@GetMapping("departmentById/{id}")
	public List<Department> getDepartmentById(@PathVariable Integer id){
		return getAllDepartment().stream().filter( dept-> dept.getId().equals(id)).collect(Collectors.toList());

	}
}
