package com.example.AccountManagementService.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.example.AccountManagementService.exception.InSufficientBalanceException;
import com.example.AccountManagementService.exception.InternalServerErrorException;
import com.example.AccountManagementService.exception.InvalidAccountDetailException;
import com.example.AccountManagementService.exception.ResourceNotFoundException;
import com.example.AccountManagementService.model.Account;
import com.example.AccountManagementService.model.Customer;
import com.example.AccountManagementService.payload.ApiResponse;
import com.example.AccountManagementService.repository.AccountRepository;
import com.example.AccountManagementService.service.AccountService;

import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public Account addAmount(String customerId, Long accountNumber, Integer userPin, Double amount) {
		// TODO Auto-generated method stub
		
		//Validate customer	
        try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		 
		
			//fetch account details
			Account getAccount = accountRepository.findById(accountNumber).orElseThrow(()-> new ResourceNotFoundException("Account "+ accountNumber + " not found on Server !!"));
			
			//Add Amount
			Double currentAmount = getAccount.getBalance();
			Double updateAmount = currentAmount + amount;
			getAccount.setBalance(updateAmount);
			
			//save Account
			accountRepository.save(getAccount);
			
			// return Account details with customer
			getAccount.setCustomer(getCustomer);
			return getAccount;
		
       }
		catch(Exception ex) {
			if( ex instanceof ResourceNotFoundException )
				throw new ResourceNotFoundException(ex.getMessage());
			else
				throw new InternalServerErrorException(ex.getMessage());
		}
	}

	@Override
	public Account withdrawAmount(String customerId, Long accountNumber, Integer userPin, Double amount) {
		// TODO Auto-generated method stub
		
		//validate customerId
         try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		 
		
			//fetch account details
			Account getAccount = accountRepository.findById(accountNumber).orElseThrow(()-> new ResourceNotFoundException("Account "+ accountNumber + " not found on Server !!"));
			
			//validate userPin
			if(!userPin.equals(getAccount.getUserPin()))
				new InvalidAccountDetailException("Invalid Account pin");
			
			//if account balance is insufficient.
			if(getAccount.getBalance().compareTo(amount) < 0)
				new InSufficientBalanceException("Your balance is insufficient to proceed a request!!");
			
			//withdraw Amount
			Double currentAmount = getAccount.getBalance();
			Double finalAmount = currentAmount - amount;
			getAccount.setBalance(finalAmount);
			
			//save Account
			accountRepository.save(getAccount);
			
			// return Account details with customer
			getAccount.setCustomer(getCustomer);
			return getAccount;
		
       }
		catch(Exception ex) {
			if( ex instanceof ResourceNotFoundException )
				throw new ResourceNotFoundException(ex.getMessage());
			else
				throw new InternalServerErrorException(ex.getMessage());
		}
	}

	@Override
	public Account getAccountDetails(String customerId, Long accountNumber) {
		// TODO Auto-generated method stub
		
		//validate customerId
         try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		
		
			//get account details
			Account getAccount = accountRepository.findById(accountNumber).orElseThrow(()-> new ResourceNotFoundException("Account "+ accountNumber + " not found on Server !!"));
			
			// return Account details with customer
			getAccount.setCustomer(getCustomer);
			return getAccount;
			
         }
			catch(Exception ex) {
				if( ex instanceof ResourceNotFoundException )
					throw new ResourceNotFoundException(ex.getMessage());
				else
					throw new InternalServerErrorException(ex.getMessage());
			}
	}

	@Override
	public String deleteAccount(String customerId, Long accountNumber) {
		// TODO Auto-generated method stub
		
		//validate customerId
         try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		
			//get account details
			Account getAccount = accountRepository.findById(accountNumber).orElseThrow(()-> new ResourceNotFoundException("Account "+ accountNumber + " not found on Server !!"));
			accountRepository.delete(getAccount);
			
			return "Successfully Customer Account "+ customerId +" Deleted!!";
		
         }
			catch(Exception ex) {
				if( ex instanceof ResourceNotFoundException )
					throw new ResourceNotFoundException(ex.getMessage());
				else
					throw new InternalServerErrorException(ex.getMessage());
			}
	}

	@Override
	public Account createAccount(String customerId, Account account) {
		// TODO Auto-generated method stub
		
		//validate customerId
	    
		try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		
		
		
	        //add customerId and CreatedDate
			account.setCustomerId(customerId);
			account.setCreateDate(LocalDateTime.now());
			
			//generate 10 digit account number
			Random random = new Random();
			Long accountNumber = 10000000 + random.nextLong(9000000);
			account.setAccountNumber(accountNumber);
			
			return accountRepository.save(account);
			
		 }
		catch(Exception ex) {
			if( ex instanceof ResourceNotFoundException )
				throw new ResourceNotFoundException(ex.getMessage());
			else
				throw new InternalServerErrorException(ex.getMessage());
		}
		
		}

	@Override
	public List<Account> getAccountsOfCustomer(String customerId) {
		// TODO Auto-generated method stub
		
        try {
			
			Customer getCustomer = webClientBuilder.build()
					.get()
					.uri("http://CUSTOMER-SERVICE/api/customer/get-customer/" + customerId)
					.retrieve()
					.onStatus(HttpStatus -> HttpStatus.is4xxClientError(), response -> response.bodyToMono(ApiResponse.class)
				                .flatMap(errorMessage -> Mono.error(new ResourceNotFoundException("Client error: " + errorMessage.getMessage()))))
					.onStatus(HttpStatus -> HttpStatus.is5xxServerError(), response -> response.bodyToMono(ApiResponse.class)
							    .flatMap(errorMessage -> Mono.error(new InternalServerErrorException("Server error: " + errorMessage.getMessage()))))
					.bodyToMono(Customer.class) 
					.block();
		
			List<Account> getallAccounts = accountRepository.findAllByCustomerId(customerId);
			return getallAccounts;
        }
        catch(Exception ex) {
			if( ex instanceof ResourceNotFoundException )
				throw new ResourceNotFoundException(ex.getMessage());
			else
				throw new InternalServerErrorException(ex.getMessage());
		}
	}
		
		
		
	
	

}
