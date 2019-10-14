package com.Employee.Repository;

import org.springframework.stereotype.Repository;

import com.Employee.Model.Department;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;

@Repository
public interface DepartmentRepository  extends DocumentDbRepository<Department, String>{

}
