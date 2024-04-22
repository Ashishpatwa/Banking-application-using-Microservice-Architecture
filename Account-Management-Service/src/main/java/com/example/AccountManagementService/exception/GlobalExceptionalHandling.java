package com.example.AccountManagementService.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.example.AccountManagementService.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionalHandling {
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		apiResponse.setSuccess(false);
		
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<ApiResponse> handleInternalServerError(InternalServerError ex){
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		apiResponse.setSuccess(false);
		
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(InvalidAccountDetailException.class)
	public ResponseEntity<Map<String,Object>> handleInvalidAccountDetailException(InvalidAccountDetailException ex){
		
		Map<String,Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("HttpStatus", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(InSufficientBalanceException.class)
	public ResponseEntity<Map<String,Object>> handleInSufficientBalanceException(InSufficientBalanceException ex){
		
		Map<String,Object> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("HttpStatus", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		
	}
	
	

}
