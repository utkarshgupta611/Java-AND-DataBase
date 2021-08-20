package com.ust.jpaasso.one2many;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaAssosiation2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empentity");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		EmployeeMany emp = new EmployeeMany();
		System.out.println("Enter <Department Name>");
		DepartmentOne dept = new DepartmentOne(scan.next());
		System.out.println("Enter <Name> <Mobile>");
		EmployeeMany emp1 = new EmployeeMany(scan.next(), scan.nextLong(),dept);
		System.out.println("Enter <Name> <Mobile>");
		EmployeeMany emp2 = new EmployeeMany(scan.next(), scan.nextLong(),dept);
		System.out.println("Enter <Name> <Mobile>");
		EmployeeMany emp3 = new EmployeeMany(scan.next(), scan.nextLong(),dept);
		System.out.println("Enter <Name> <Mobile>");
		EmployeeMany emp4 = new EmployeeMany(scan.next(), scan.nextLong(),dept);
		dept.addEmployee(emp4);
		dept.addEmployee(emp3);
		dept.addEmployee(emp2);
		dept.addEmployee(emp1);
		em.persist(dept);
		em.getTransaction().commit();
		em.close();
		
		
	}

}
