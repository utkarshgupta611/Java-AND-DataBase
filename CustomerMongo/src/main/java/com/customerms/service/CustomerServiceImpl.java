package com.customerms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerms.entity.Customer;
import com.customerms.exception.CustomerException;
import com.customerms.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public Customer add(String id, String name, int age) {
		Customer cust = new Customer(id, name, age);
		Customer saved = repo.save(cust);  //226	
		return saved;
	}

	@Override
	public Customer find(String id) {
		Optional<Customer> op =  repo.findById(id);
		if(!op.isPresent()) {
			throw new CustomerException("Customer not found for id: "+id);
		}
		return op.get();
	}

}
