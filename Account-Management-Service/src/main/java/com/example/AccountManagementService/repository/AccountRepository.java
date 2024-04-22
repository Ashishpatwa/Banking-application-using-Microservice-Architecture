package com.example.AccountManagementService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AccountManagementService.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findAllByCustomerId(String customerId);

}
