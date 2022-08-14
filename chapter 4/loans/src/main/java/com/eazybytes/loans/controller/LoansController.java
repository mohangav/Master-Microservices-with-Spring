package com.eazybytes.loans.controller;

import com.eazybytes.loans.config.LoansServiceConfig;
import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.model.Properties;
import com.eazybytes.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoansController {

	@Autowired
	LoansRepository loansRepository;

	@Autowired
	LoansServiceConfig loansConfig;
	
	@PostMapping("/myLoans")
	public List<Loans> getLoans(@RequestHeader("eazybank-correlation-id") String correlationid,
								@RequestBody Customer customer) {
		
		List<Loans> loansList =  loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		
		if(loansList!=null) {
			return loansList;
		} else {
			return null;
		}
	}

	@GetMapping("/loans/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
				loansConfig.getMailDetails(), loansConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
}
