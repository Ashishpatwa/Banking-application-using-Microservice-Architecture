package com.example.CustomerManagementService.service;

import java.util.List;

import com.example.CustomerManagementService.model.Customer;

public interface CustomerService {
	
	
	Customer addCustomer(Customer customer);
	Customer getSpecificCustomer(String customerId);
	List<Customer> getAllCustomer();
	Customer updateCustomer(String customerId, Customer customer);
	List<String> deleteCustomer(String customerId);

}
