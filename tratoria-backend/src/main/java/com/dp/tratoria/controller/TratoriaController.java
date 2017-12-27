package com.dp.tratoria.controller;

import java.util.ArrayList;
import java.util.List;

import com.dp.tratoria.response.CustomerResponse;
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

    private static final String CUSTOMERS = "/customers";
    private static final String CUSTOMERS_ID_MAPPING = "/customers/{id}";
    private static final String TRATORIA_DELETE_BY_ID = "Tratoria delete by Id : {}";
    private static final String TRATORIA_FIND_ALL = "Tratoria find All";
    private static final String TRATORIA_FIND_BY_ID = "Tratoria find By Id : {}";
    private static final String TRATORIA_INSERT_OR_UPDATE = "Tratoria insert or update";
    private static final String TRATORIA_INSERT_NEW_CUSTOMER = "Tratoria insert new customer";
    private static final String TRATORIA_UPDATE_EXISTING_CUSTOMER = "Tratoria Update Existing Customer";

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = CUSTOMERS_ID_MAPPING, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CustomerResponse delete(@PathVariable String id) throws Exception {
        log.info(TRATORIA_DELETE_BY_ID, id);
        Customer customer = customerService.get(id.trim());
        customer.setDelete(true);
        Customer result = customerService.update(customer);
        CustomerResponse response = mapToCustomerResponse(result);
        return response;
    }

    @RequestMapping(value = CUSTOMERS, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<CustomerResponse> findAll() throws Exception {
        log.info(TRATORIA_FIND_ALL);
        List<Customer> customers = customerService.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<CustomerResponse>();
        for (Customer customer : customers) {
            CustomerResponse response = mapToCustomerResponse(customer);
            customerResponses.add(response);
        }
        return customerResponses;
    }

    @RequestMapping(value = CUSTOMERS_ID_MAPPING, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CustomerResponse findById(@PathVariable String id) throws Exception {
        log.info(TRATORIA_FIND_BY_ID, id);
        Customer result = customerService.get(id.trim());
        CustomerResponse response = mapToCustomerResponse(result);
        return response;
    }

    @RequestMapping(value = CUSTOMERS, method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public CustomerResponse insertOrUpdate(@RequestBody CustomerRequest customerRequest) throws Exception {
        log.info(TRATORIA_INSERT_OR_UPDATE);
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        Customer result = null;
        if (customer.getId() != null) {
            log.info(TRATORIA_UPDATE_EXISTING_CUSTOMER);
            result = customerService.update(customer);
        } else {
            log.info(TRATORIA_INSERT_NEW_CUSTOMER);
            result = customerService.save(customer);
        }
        CustomerResponse response = mapToCustomerResponse(result);
        return response;
    }

    private CustomerResponse mapToCustomerResponse(Customer result) {
        CustomerResponse response = new CustomerResponse();
        BeanUtils.copyProperties(result, response);
        return response;
    }

}
