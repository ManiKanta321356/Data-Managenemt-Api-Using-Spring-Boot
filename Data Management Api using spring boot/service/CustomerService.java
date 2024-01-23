package com.manikanta.www.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manikanta.www.customexception.BusinessException;
import com.manikanta.www.model.Customer;
import com.manikanta.www.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cr;
	
	public List<Customer> getAllCustomer() {
		List<Customer> list=null;
		try {
			list=cr.findAll();
			
		}catch(Exception e) {
			throw new BusinessException("607", "Something went wrong while fetching details");
		}
		if(list.isEmpty())
			throw new BusinessException("606", "we have nothinf to return");
		return list;
	}
		


	public void updateCustomer(Customer customer) {
		Customer cust = cr.findById(customer.getId()).get();
		if(cust.getCustname()== customer.getCustname() && cust.getCustaddr()==customer.getCustaddr()) {
			throw new BusinessException("605", "the values are same.its unnecessary to update.");
		}
		try {	
			cust.setCustname(customer.getCustname());
			cust.setCustaddr(customer.getCustaddr());
			
			cr.save(cust);
		}
		catch(IllegalArgumentException e) {
			throw new BusinessException("604","Id must be given while updating"+e.getMessage());
		}
	}

	public void addCustomer(Customer customer) {
		
		if(customer.getCustname().isEmpty() || customer.getCustname().length()==0) {
			throw new BusinessException("601","customer name should not be null ");
		}
		try {
			
			cr.save(customer);
		}
		catch(IllegalArgumentException e){
			throw new BusinessException("602", "given customer is null" + e.getMessage());
		}
		
		catch(Exception e) {
			throw new BusinessException("603", "Something went wrong"+e.getMessage());
		}
		
	}


	public Customer getCustomerById(int id) {
		try {
			return cr.findById(id).get();
		}
		catch(IllegalArgumentException e){
			throw new BusinessException("608", "given customer is null" + e.getMessage());
		}
		
		catch(NoSuchElementException e) {
			throw new BusinessException("609", "There is no such element in database" );
		}
		
	}


	public void deleteById(int id) {
		try {
			cr.deleteById(id);
		}
		catch(IllegalArgumentException e){
			throw new BusinessException("610", "given customer is null" + e.getMessage());
		}
		catch(NoSuchElementException e) {
			throw new BusinessException("611", "There is no such element in database to delete" + e.getMessage());
		}
		
		
	}

}
