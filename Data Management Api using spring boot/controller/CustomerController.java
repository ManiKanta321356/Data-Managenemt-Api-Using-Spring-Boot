package com.manikanta.www.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manikanta.www.customexception.BusinessException;
import com.manikanta.www.customexception.ControllerException;
import com.manikanta.www.model.Customer;
import com.manikanta.www.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@GetMapping("/get")
	public List<Customer> getAllCustomer(){
		
		return cs.getAllCustomer();
	}
	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer) {
		
		cs.updateCustomer(customer);
		
	}
	
	@PostMapping("/add")
	public void addCustomer(@Valid@RequestBody Customer customer) {
		cs.addCustomer(customer);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable int id){
		try {
			Customer cust = cs.getCustomerById(id);
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		}
		catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException ce = new ControllerException("612","Something went wrong");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable int id){
		try {
			cs.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}catch(BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce = new ControllerException("614","Something went wrong");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
