package com.dp.tratoria.repository.impl;

import com.dp.tratoria.model.Customer;
import com.dp.tratoria.repository.CustomerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private static final String IS_DELETE = "isDelete";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long countActiveCustomers() {
        Query query = new Query();
        query.addCriteria(Criteria.where(IS_DELETE).is(false));
        return mongoTemplate.count(query,Customer.class);
    }

    @Override
    public List<Customer> getActiveCustomers(int skip, int limit) {
        Query query = new Query();
        query.addCriteria(Criteria.where(IS_DELETE).is(false));
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query,Customer.class,"customer");
    }

}
