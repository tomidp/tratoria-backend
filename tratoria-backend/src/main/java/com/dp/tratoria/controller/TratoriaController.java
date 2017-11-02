package com.dp.tratoria.controller;

import java.util.List;
import java.util.UUID;

import com.dp.tratoria.request.CustomerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.dp.tratoria.model.Customer;
import com.dp.tratoria.service.CustomerService;

@RestController
@RequestMapping("/api/tratoria")
public class TratoriaController {
	
	private static final Logger log = LoggerFactory.getLogger(TratoriaController.class);
	
	@Autowired
	private CustomerService customerService;
	
    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Customer> findAll() throws Exception {
    	log.info("Tratoria Controller Find All");
        return customerService.findAll();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Customer insert(@RequestBody CustomerRequest customer) throws Exception {
        log.info("Tratoria Controller Insert");
        Customer cust = new Customer();
        BeanUtils.copyProperties(customer, cust);
        return customerService.save(cust);
    }

}
