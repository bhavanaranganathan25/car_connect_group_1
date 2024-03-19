package com.exception;

public class AdminNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	public AdminNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
    	

}
