package com.dp.tratoria.service;

import java.util.List;

import com.dp.tratoria.model.Customer;

public interface CustomerService {

	long countActiveCustomers();

	List<Customer> findAll();

	List<Customer> findActiveCustomers(int skip, int limit);

	Customer get(String id);

	Customer save(Customer customer);

	Customer update(Customer customer);

}
