package com.employee.soumya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.soumya.entities.Employee;

public interface EmployeeService {
	
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee updateEmployeeById(@PathVariable Integer id, @RequestBody Employee updateEmployee);
	
	public String deleteEmployeeById(Integer id);
	
	public Employee getEmployeeById(@PathVariable Integer id);
	

}
