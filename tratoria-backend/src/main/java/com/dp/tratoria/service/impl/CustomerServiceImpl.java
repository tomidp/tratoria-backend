package com.dp.tratoria.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.tratoria.model.Customer;
import com.dp.tratoria.repository.CustomerRepository;
import com.dp.tratoria.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

//	Enable when first run to construct data
//	@PostConstruct
//	private void constructAll() throws Exception {
//		repository.save(new Customer(UUID.randomUUID().toString(), "Anistia", "Rivani"));
//		repository.save(new Customer(UUID.randomUUID().toString(), "Kalila", "Avani"));
//		repository.save(new Customer(UUID.randomUUID().toString(), "Yayuk", "Rahayu"));
//		repository.save(new Customer(UUID.randomUUID().toString(), "Elsa", "Marini"));
//		repository.save(new Customer(UUID.randomUUID().toString(), "Ekkie", "Surya"));
// }


	@Override
	public List<Customer> findAll() {
		return repository.findAll();
	}

	@Override
	public Customer get(String id) {
		return repository.findOne(id);
	}

	@Override
	public Customer save(Customer customer) {
		customer.setId(UUID.randomUUID().toString());
		return repository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return repository.save(customer);
	}

	

}
