package com.dp.tratoria.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dp.tratoria.model.Customer;
import com.dp.tratoria.service.CustomerService;

@RestController
@RequestMapping("/api/tratoria")
public class TratoriaController {
	
	private static final Logger log = LoggerFactory.getLogger(TratoriaController.class);
	
	@Autowired
	private CustomerService customerService;
	
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Customer> findAll() {
    	log.info("Tratoria Controller Find All");
        return customerService.findAll();
    }

}
