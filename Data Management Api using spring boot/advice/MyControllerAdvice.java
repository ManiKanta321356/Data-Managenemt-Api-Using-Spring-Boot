package com.manikanta.www.advice;

import java.util.NoSuchElementException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.manikanta.www.customexception.EmptyInputException;

@ControllerAdvice
@ComponentScan
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input fileds are empty please look into it", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException emelemntException){
		return new ResponseEntity<String>("There is no such value in database", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException elementException){
		return new ResponseEntity<String>("The value should not be null",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
	    return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
