package com.ecommerceapp.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.entities.Country;
import com.ecommerceapp.entities.State;
import com.ecommerceapp.repos.CreditCardRepository;

@RestController
@RequestMapping("/cc")
@CrossOrigin
public class CreditCardController {
	
	@Autowired
	CreditCardRepository repo;
	
	@GetMapping(path = {"/countries"})
	public List<Country> getListOfCountries() {
		return repo.findAll();
	}
	
	@GetMapping(path = {"/countries/{code}/states"})
	public List<State> getListOfStates(@PathVariable int code) {
		return repo.findByCode(code);
	}

}
