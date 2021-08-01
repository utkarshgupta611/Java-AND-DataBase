package com.customerms.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customerms.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
