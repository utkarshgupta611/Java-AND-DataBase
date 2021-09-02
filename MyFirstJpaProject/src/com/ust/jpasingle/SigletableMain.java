package com.ust.jpasingle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SigletableMain {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("custentity");
	EntityManager em = emf.createEntityManager();
	
	Employee emp = new Employee();
	Manager1 mgr = new Manager1();
//	     Insert
	em.getTransaction().begin();
	emp.setName("Utkarsh");
	mgr.setName("arsh");
	
	emp.setMobile(9041120661L);
	mgr.setMobile(946431321L);
	
	mgr.setDept("Development");

	em.persist(emp);
	em.persist(mgr);
	em.getTransaction().commit();
}
}
