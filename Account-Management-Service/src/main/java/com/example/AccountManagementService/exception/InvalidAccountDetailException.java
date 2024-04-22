package com.example.AccountManagementService.exception;

public class InvalidAccountDetailException extends RuntimeException{
	
	public InvalidAccountDetailException() {
		super("Resource Not Found on Server!!");
	}
	
	public InvalidAccountDetailException(String message) {
		super(message);
	}

}
