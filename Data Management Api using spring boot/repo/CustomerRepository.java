package com.manikanta.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manikanta.www.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
