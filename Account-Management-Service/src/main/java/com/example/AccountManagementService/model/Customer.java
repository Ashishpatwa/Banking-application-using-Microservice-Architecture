package com.example.AccountManagementService.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


public class Customer {
	
	
	private String customerId;
	private String customerName;
	private String gmail;
	private Long phnNo;
	private String address;
	private Integer pincode;
	private LocalDate dateOfBirth;
	private List<Account>accounts = new ArrayList<Account>();
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String customerId, String customerName, String gmail, Long phnNo, String address, Integer pincode,
			LocalDate dateOfBirth, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gmail = gmail;
		this.phnNo = phnNo;
		this.address = address;
		this.pincode = pincode;
		this.dateOfBirth = dateOfBirth;
		this.accounts = accounts;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public Long getPhnNo() {
		return phnNo;
	}


	public void setPhnNo(Long phnNo) {
		this.phnNo = phnNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getPincode() {
		return pincode;
	}


	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	

}
