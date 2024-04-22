package com.example.CustomerManagementService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.CustomerManagementService.model.Customer;
import com.example.CustomerManagementService.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add-customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		
		
		Customer newCustomer = customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get-all-customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> newCustomer = customerService.getAllCustomer();
		return new ResponseEntity<List<Customer>>(newCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/get-customer/{customerId}")
	public ResponseEntity<Customer> getSpecificCustomer(@PathVariable("customerId") String customerId){
		
		
		Customer customer = customerService.getSpecificCustomer(customerId);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	@PutExchange("/update-customer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") String customerId, @RequestBody Customer customer){
		
		Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-customer/{customerId}")
	public ResponseEntity<List<String>> deleteCustomer(@PathVariable("customerId") String customerId){
		
		List<String> deleteCustomer = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<String>>(deleteCustomer, HttpStatus.OK);
	}
	
	

}
