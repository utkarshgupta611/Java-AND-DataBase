package com.ust.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainUI {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("custentity");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter <NAME MOBILE>");
		CustomerEntity cust = new CustomerEntity();

		String name = scan.next();
		Long mobile = scan.nextLong();


		cust.setName(name);
		cust.setNumber(mobile);
		
		em.persist(cust);
		em.getTransaction().commit();
		em.close();
		scan.close();

	}

}
