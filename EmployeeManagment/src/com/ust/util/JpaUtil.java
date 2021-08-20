package com.ust.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.ust.exception.EmployeeException;
import com.ust.exception.Message;

public class JpaUtil {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager getEntityManager() throws EmployeeException {
		try {
			if (em == null || !em.isOpen()) {
				emf = Persistence.createEntityManagerFactory("empentity");
				em = emf.createEntityManager();
			}
		} catch (Exception e) {
			throw new EmployeeException(Message.JPA_ERROR);
		}
		return em;
	}

	public static void close() {
		if (em != null)
			em.close();
	}
}
