package com.ust.jpainheritance;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class InheritanceMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("custentity");
	EntityManager em = emf.createEntityManager();
	
//	Employee emp = new Employee();
//	Manager mgr = new Manager();
	    // Insert
//	em.getTransaction().begin();
//	emp.setName("Utkarsh");
//	mgr.setName("arsh");
//	
//	emp.setMobile(9041120661L);
//	mgr.setMobile(946431321L);
//	
//	mgr.setDept("Development");
//
//	em.persist(emp);
//	em.persist(mgr);
//	em.getTransaction().commit();
	
em.getTransaction().begin();
System.out.println("enter id");	
Scanner scan = new Scanner(System.in);
int id = scan.nextInt();
Manager empList = em.find(Manager.class, id);
em.getTransaction().commit();
System.out.println(empList);
scan.close();
	
}
}
