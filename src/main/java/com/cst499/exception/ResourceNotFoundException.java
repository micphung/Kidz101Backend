package com.cst499.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//api will return a not found status to the client 
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	// when data does not exist in a database we can throw this exception
	
	
	private static final long serialVersionUID = 1L;
	
	// we pass a message to the superclass
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
