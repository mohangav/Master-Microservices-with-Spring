package com.eazytbytes.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazytbytes.accounts.model.Accounts;
import com.eazytbytes.accounts.model.Customer;
import com.eazytbytes.accounts.repository.AccountsRepository;

@RestController
public class AccountController {

	@Autowired
	AccountsRepository accountsRepository;
	
	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		
		if(accounts != null) {
			return accounts;
		}
		return null;
	}
}
