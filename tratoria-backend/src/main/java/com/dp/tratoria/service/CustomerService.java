package com.dp.tratoria.service;

import java.util.List;

import com.dp.tratoria.model.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer get(String id);

	Customer save(Customer customer);

	Customer update(Customer customer);

}
