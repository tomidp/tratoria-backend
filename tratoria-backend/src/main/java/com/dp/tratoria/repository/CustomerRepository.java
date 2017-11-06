package com.dp.tratoria.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dp.tratoria.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>, CustomerRepositoryCustom {

	public List<Customer> findByFirstName(String firstName);
	
	public List<Customer> findByLastName(String lastName);
	
}
