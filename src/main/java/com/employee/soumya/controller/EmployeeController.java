package com.employee.soumya.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.soumya.entities.Employee;
import com.employee.soumya.service.EmployeeService;





@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired(required=true)
	private EmployeeService empService;
	
	@GetMapping(value="/test")
	public String firstHandler() {
		return "Hello";
	}
	
	@PostMapping(value="/addEmp")
	public Employee addEmployee(@Valid @RequestBody  Employee employee) {
		Employee emp =  empService.addEmployee(employee);
		return emp;	
	}
	
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>>getAllEmployees(){
		List<Employee> emp =  empService.getAllEmployees();
		System.out.println(emp.size());
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@Valid @PathVariable Integer id, @RequestBody Employee updateEmployee){
		StringBuilder errorMessage = new StringBuilder("Validation error(s): ");
		Employee emp = empService.updateEmployeeById(id,updateEmployee );
		return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
    }	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id) {
		 if (id == null) {
		        return ResponseEntity.badRequest().body("ID must not be null.");
		    }
		empService.deleteEmployeeById(id);
		return ResponseEntity.ok("success");
		
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee emp = empService.getEmployeeById(id);
			return ResponseEntity.ok(emp);
	
		
		
	} 
	
	
}
