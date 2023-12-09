package com.employee.soumya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@ComponentScan(
//	basePackages = {"com.employee.soumya.service"}
//)
@SpringBootApplication(scanBasePackages = {"com.employee.soumya","com.employee.soumya.controller"})
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
