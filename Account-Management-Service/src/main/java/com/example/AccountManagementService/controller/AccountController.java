package com.example.AccountManagementService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AccountManagementService.model.Account;
import com.example.AccountManagementService.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	
	
	
	@PostMapping("/create-account/{customerId}")
	public ResponseEntity<Account> createAccount(@PathVariable("customerId") String customerId, @RequestBody Account account){
		
		Account newAccount = accountService.createAccount(customerId, account);
		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/add-amount/{customerId}/{accountNumber}/{userPin}/{amount}")
	public ResponseEntity<Account> addAmount(@PathVariable("customerId") String customerId, @PathVariable("accountNumber") Long accountNumber, @PathVariable("userPin") Integer userPin, @PathVariable("amount") Double amount){
		
		
		Account updatedAccount = accountService.addAmount(customerId, accountNumber, userPin, amount);
		return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
			
	}
	
	
	@PutMapping("/withdraw-amount/{customerId}/{accountNumber}/{userPin}/{amount}")
	public ResponseEntity<Account> withdrawAmount(@PathVariable("customerId") String customerId, @PathVariable("accountNumber") Long accountNumber, @PathVariable("userPin") Integer userPin,@PathVariable("amount") Double amount){
		
		Account updatedAccount = accountService.withdrawAmount(customerId, accountNumber, userPin, amount);
		return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
		
	}
	
	@GetMapping("/get-details/{customerId}/{accountNumber}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable("customerId") String customerId, @PathVariable("accountNumber") Long accountNumber){
		
		Account getAccount = accountService.getAccountDetails(customerId, accountNumber);
		return new ResponseEntity<>(getAccount, HttpStatus.OK);
		
	}
	
	@GetMapping("/get-accounts-of-customer/{customerId}")
	public ResponseEntity<List<Account>> getAccountsOfCustomer(@PathVariable("customerId") String customerId){
		
		List<Account> getAccount = accountService.getAccountsOfCustomer(customerId);
		return new ResponseEntity<>(getAccount, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete-account/{customerId}/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable("customerId") String customerId, @PathVariable("accountNumber") Long accountNumber){
		
		String deleteAccount = accountService.deleteAccount(customerId, accountNumber);
		return new ResponseEntity<>(deleteAccount, HttpStatus.OK);
		
	}
	
}
