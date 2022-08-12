package com.eazybytes.cards.controller;

import java.util.List;

import com.eazybytes.cards.config.CardsServiceConfig;
import com.eazybytes.cards.model.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.cards.model.Cards;
import com.eazybytes.cards.model.Customer;
import com.eazybytes.cards.repository.CardsRepository;

@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardRepository;

	@Autowired
	CardsServiceConfig cardsConfig;


	@PostMapping("/myCards")
	public List<Cards> getCardsByCustomer(@RequestHeader("eazybank-correlation-id") String correlationid,
										  @RequestBody Customer customer) {
		
		List<Cards> cards = cardRepository.findByCustomerId(customer.getCustomerId());
		
		return cards;
	}

	@GetMapping("/cards/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
				cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}

}
