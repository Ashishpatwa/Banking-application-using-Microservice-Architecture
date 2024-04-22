package com.example.CustomerManagementService.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;



@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="customer_Id")
	private String customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_gmail")
	private String gmail;
	
	@Column(name="phone_Number", length=10)
	private Long phnNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pincode", length=6)
	private Integer pincode;
	
	
	@Column(name="data_of_birth")
	private LocalDate dateOfBirth;
	
	@Transient
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





	public List<Account> getAccounts() {
		return accounts;
	}




	public void setAccounts(List<Account> accounts) {
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
	
	
	

	

}
