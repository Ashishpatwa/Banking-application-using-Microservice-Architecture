package com.example.CustomerManagementService.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.CustomerManagementService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionalHandling {
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		Map<String,Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("HttpStatus", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ApiResponse> handleInternalServerError(InternalServerError ex){
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		apiResponse.setSuccess(false);
		
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	

}
