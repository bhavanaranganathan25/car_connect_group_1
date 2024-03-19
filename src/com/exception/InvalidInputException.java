package com.exception;

public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;

	public InvalidInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
