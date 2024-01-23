package com.manikanta.www.customexception;

import org.springframework.stereotype.Component;

@Component
public class EmptyInputException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private String getError;
	
	private String getMessage;



	public EmptyInputException(String getError, String getMessage) {
		super();
		this.getError = getError;
		this.getMessage = getMessage;
	}



	public String getGetError() {
		return getError;
	}



	public void setGetError(String getError) {
		this.getError = getError;
	}



	public String getGetMessage() {
		return getMessage;
	}



	public void setGetMessage(String getMessage) {
		this.getMessage = getMessage;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public EmptyInputException() {
		
	}


}
