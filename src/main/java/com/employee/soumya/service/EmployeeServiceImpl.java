package com.employee.soumya.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.soumya.entities.Employee;
import com.employee.soumya.repo.EmployeeRepo;

import jakarta.transaction.Transactional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
//		Employee emp = new Employee();
//		list.add(employee);
		employeeRepo.save(employee);
		return employee;
		
	}

	@Override
//	@Transactional
//	public List<Employee> getAllEmployees() {
//		List<Employee> list = new ArrayList<>();
//		Iterable<Employee> emp =  employeeRepo.findAll();
//		for(Employee e : emp) {
//			list.add(e);
//			
//		}
//		return list;
//	}
	
	@Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

	@Override
	public Employee updateEmployeeById(Integer id, Employee updateEmployee) {
		 Optional<Employee> empOptional = employeeRepo.findById(id);
		    
		    if (empOptional.isPresent()) {
		        Employee emp = empOptional.get();
		        emp.setEmpName(updateEmployee.getEmpName());
		        emp.setEmail(updateEmployee.getEmail());
		        emp.setLocation(updateEmployee.getLocation());
		        emp.setSalary(updateEmployee.getSalary());
		        emp.setDesignation(updateEmployee.getDesignation());
		        return employeeRepo.save(emp);
	}
			return updateEmployee;

}

	@Override
	public String deleteEmployeeById(Integer id) {
		employeeRepo.deleteById(id);
		return "success";
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		 Optional<Employee> employeeOptional = employeeRepo.findById(id);
		 return employeeOptional.orElse(null);
		
	}
}

