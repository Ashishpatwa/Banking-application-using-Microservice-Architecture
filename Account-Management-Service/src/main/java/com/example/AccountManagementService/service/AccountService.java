package com.example.AccountManagementService.service;

import java.util.List;

import com.example.AccountManagementService.model.Account;

public interface AccountService {
	
	Account createAccount(String customerId, Account account);
	Account addAmount(String customerId, Long accountNumber, Integer userPin, Double amount);
	Account withdrawAmount(String customerId, Long accountNumber, Integer userPin, Double amount);
	Account getAccountDetails(String customerId, Long accountNumber);
	String deleteAccount(String customerId, Long accountNumber);
	List<Account> getAccountsOfCustomer(String customerId);

}
