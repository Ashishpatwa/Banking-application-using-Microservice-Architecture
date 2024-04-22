package com.example.CustomerManagementService.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	
	
	private String message;
	private boolean success;
	private HttpStatus httpStatus;
	
	
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiResponse(String message, boolean success, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.success = success;
		this.httpStatus = httpStatus;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	

}
