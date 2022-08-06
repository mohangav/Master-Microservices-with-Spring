package com.eazytbytes.accounts.controller;

import com.eazytbytes.accounts.config.AccountsServiceConfig;
import com.eazytbytes.accounts.model.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@Autowired
	AccountsServiceConfig accountsConfig;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		
		if(accounts != null) {
			return accounts;
		}
		return null;
	}

	@GetMapping("/account/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
				accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}

}
