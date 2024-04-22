package com.example.CustomerManagementService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


public class Account {

    private String accountNumber;
    private String accountType;
    private String customerId;
    private Double balance;
    private Double rateOfInterest;
    private LocalDateTime createDate;
    
    
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(String accountNumber, String accountType, String customerId, Double balance, Double rateOfInterest,
			LocalDateTime createDate) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customerId = customerId;
		this.balance = balance;
		this.rateOfInterest = rateOfInterest;
		this.createDate = createDate;
	}


	


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Double getRateOfInterest() {
		return rateOfInterest;
	}


	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}


	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
    
    
    

	
    
}
