package com.employee.soumya.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		 BindingResult result = exception.getBindingResult();
	        StringBuilder errorMessage = new StringBuilder("Validation error(s): ");

	        result.getFieldErrors().forEach(fieldError ->
	                errorMessage.append(fieldError.getField())
	                        .append(" ")
	                        .append(fieldError.getDefaultMessage())
	                        .append("; ")
	        );

	        return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
	}

}
