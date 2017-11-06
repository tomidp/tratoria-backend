package com.dp.tratoria.repository;


import com.dp.tratoria.model.Customer;
import java.util.List;

public interface CustomerRepositoryCustom {

    long countActiveCustomers();

    List<Customer> getActiveCustomers(int skip, int limit);

}
