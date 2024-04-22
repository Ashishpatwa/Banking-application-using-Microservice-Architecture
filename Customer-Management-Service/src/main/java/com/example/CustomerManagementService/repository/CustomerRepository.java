package com.example.CustomerManagementService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CustomerManagementService.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
