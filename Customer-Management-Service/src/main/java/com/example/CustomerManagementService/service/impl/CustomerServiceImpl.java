package com.example.CustomerManagementService.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.CustomerManagementService.exceptions.InternalServerErrorException;
import com.example.CustomerManagementService.exceptions.ResourceNotFoundException;
import com.example.CustomerManagementService.model.Account;
import com.example.CustomerManagementService.model.Customer;
import com.example.CustomerManagementService.payload.ApiResponse;
import com.example.CustomerManagementService.repository.CustomerRepository;
import com.example.CustomerManagementService.service.CustomerService;

import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String customerId = "CustomerId-" + UUID.randomUUID().toString();
		customer.setCustomerId(customerId);
		return customerRepository.save(customer);
	}


	@Override
	public Customer getSpecificCustomer(String customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("User with "+ customerId + " not found on server!!"));
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(String customerId, Customer customer) {
		// TODO Auto-generated method stub
		
		Customer getCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("User with " + customerId + " not found on Server!!"));
		
		getCustomer.setCustomerName(customer.getCustomerName());
		getCustomer.setAddress(customer.getAddress());
		getCustomer.setGmail(customer.getGmail());
		getCustomer.setDateOfBirth(customer.getDateOfBirth());
		getCustomer.setPhnNo(customer.getPhnNo());
		getCustomer.setPincode(customer.getPincode());
		
		return customerRepository.save(getCustomer);
		
	}

	@Override
	public List<String> deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		
		  try {
				
			  Account[] getAccounts = webClientBuilder.build()
					  .get()
						.uri("http://ACCOUNT-SERVICE/api/account/get-accounts-of-customer/" + customerId)
						.retrieve()
						.bodyToMono(Account[].class) 
						.block();
			  
			  
			  List<Account> accounts = Arrays.stream(getAccounts).toList();
			  
			  List<String> allDeletedAccount = accounts.stream().map(account -> {
					  
				    return webClientBuilder.build()
						  .delete()
						  .uri("http://ACCOUNT-SERVICE/api/account/delete-account/" + customerId + "/" + account.getAccountNumber())
						  .retrieve()
						  .bodyToMono(String.class)
						  .block();
				  
			  }).collect(Collectors.toList());
			  
			  
			  
				Customer getCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("User with " + customerId + " not found on Server!!"));
				customerRepository.deleteById(customerId);
				
				allDeletedAccount.add("Successfully removed customer " + customerId);
				
				return allDeletedAccount;
			
	       }
		catch(Exception ex) {
			if( ex instanceof ResourceNotFoundException )
				throw new ResourceNotFoundException(ex.getMessage());
			else
			    throw new InternalServerErrorException(ex.getMessage());
		}
		
	
	}

	
}
