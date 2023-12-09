package com.employee.soumya.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.soumya.entities.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	List<Employee> findAll();
	Optional<Employee> findById(Integer id);
	Employee getById(Integer id);
	
	 

}
