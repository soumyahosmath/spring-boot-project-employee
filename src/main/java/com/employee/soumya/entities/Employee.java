package com.employee.soumya.entities;



import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int empID;
	
	@Column(name="name")
	@NotBlank(message="name can not be null")
	private String empName;
	
	@Size(min=5, message="should be greater than 5 char")
	@Email(message = "Invalid email address")
	private String email;
	
	@NotEmpty(message = "Designation cannot be empty")
	private String designation;
	
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "1000000.0", inclusive = true, message = "Salary must be less than or equal to 1,000,000")
	private double salary;
	
	private String location;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee(int empID, @NotBlank(message = "name can not be null") String empName,
			@Size(min = 5, message = "should be greater than 5 char") @Email(message = "Invalid email address") String email,
			@NotEmpty(message = "Designation cannot be empty") String designation,
			@DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0") @DecimalMax(value = "1000000.0", inclusive = true, message = "Salary must be less than or equal to 1,000,000") double salary,
			String location) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.email = email;
		this.designation = designation;
		this.salary = salary;
		this.location = location;
	}
	public Employee() {
		super();
	}
	
	

}
