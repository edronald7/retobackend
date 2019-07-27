package com.retobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retobackend.business.DateRules;
import com.retobackend.model.Customer;
import com.retobackend.model.CustomerStats;
import com.retobackend.repository.CustomerRepository;
import com.retobackend.repository.CustomerStatsRepository;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	int DATO_EXTERNO_ESPERANZA_DE_VIDA = 85; 
	//Dato que seria extraido de alguna fuente externa o esperanza de vida.
	//Estableceremos a 85 años como edad promedio de vida (supuesto/ejemplo).
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerStatsRepository statsRepository;
	
	@Autowired
	private DateRules rules;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setEdad(rules.yearsOld(customer.getFechaNacimiento()));
		customer.setFechaMuerte(
				rules.deathDate(
						customer.getFechaNacimiento(), 
						this.DATO_EXTERNO_ESPERANZA_DE_VIDA
						)
				);
		return repository.save(customer);
	}
	
	@GetMapping(produces = "application/json")
	public List findAll() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/statistics", produces = "application/json")
	public CustomerStats getStatsCustomer() {
		return statsRepository.getStatsInfo();
	}
	
}
