package com.example.AccountManagementService.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "account")
public class Account {

    @Id   
    @Column(name = "account_number") 
    private Long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "rate_of_interest")
    private Double rateOfInterest;
    
    @Column(name="user_pin", length=6)
	private Integer userPin;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    
    @Transient
    private Customer customer;
    
    

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Account(Long accountNumber, String accountType, String customerId, Double balance, Double rateOfInterest,
			Integer userPin, LocalDateTime createDate, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customerId = customerId;
		this.balance = balance;
		this.rateOfInterest = rateOfInterest;
		this.userPin = userPin;
		this.createDate = createDate;
		this.customer = customer;
	}







	public Long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
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



	public Integer getUserPin() {
		return userPin;
	}



	public void setUserPin(Integer userPin) {
		this.userPin = userPin;
	}



	public LocalDateTime getCreateDate() {
		return createDate;
	}



	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
    
    
	
    

	
    
}
