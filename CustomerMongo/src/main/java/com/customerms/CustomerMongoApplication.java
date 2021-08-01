package com.customerms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.customerms.entity.Customer;
import com.customerms.service.CustomerService;

@SpringBootApplication
@EnableMongoRepositories
public class CustomerMongoApplication {
 
	@Autowired
	private CustomerService custService;
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CustomerMongoApplication.class, args);
		CustomerMongoApplication ca = ctx.getBean(CustomerMongoApplication.class);
		ca.start();
	}

	private void start() {
		Customer cust1 = custService.add("1", "Jishnu", 21);
		display(cust1);
		Customer cust2 = custService.add("2", "Utkarsh", 22);
		display(cust2);
		Customer cust3 = custService.add("3", "Nidhi", 20);
		display(cust3);
		System.out.println("*** added two objects");
		Customer cust4 = custService.find("1");
		display(cust4);
		System.out.println("** found obj");
		
	}

	private void display(Customer cust) {
		System.out.println(cust.getId()+" - "+cust.getName()+" - "+cust.getAge());
	}

}
