package com.dp.tratoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dp.tratoria.model.Customer;
import com.dp.tratoria.service.CustomerService;

@RestController
@RequestMapping("/api/tratoria")
public class TratoriaController {
	
	@Autowired
	private CustomerService customerService;
	
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

}
