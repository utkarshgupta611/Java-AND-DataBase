package com.customerms.service;

import com.customerms.entity.Customer;

public interface CustomerService {

	Customer add (String id, String name, int age);
	Customer find (String id);
}
