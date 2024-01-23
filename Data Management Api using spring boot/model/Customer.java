package com.manikanta.www.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Customer {
	@Id
	private int id;
	@NotBlank(message="please fill customer name")
	private String custname;
	
	private String custaddr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustaddr() {
		return custaddr;
	}

	public void setCustaddr(String custaddr) {
		this.custaddr = custaddr;
	}




}
