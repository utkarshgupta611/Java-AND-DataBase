package com.ust.jpaasso.one2one;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaAssosiateMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empentity");
		EntityManager em = emf.createEntityManager();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter <Street name> <City>");
		Address address = new Address(scan.next(), scan.next());
		
		System.out.println("Enter <Name> <Mobile> ");
		Employee employee = new Employee(scan.next(),scan.nextLong(), address);
		
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		scan.close();
	}

}
