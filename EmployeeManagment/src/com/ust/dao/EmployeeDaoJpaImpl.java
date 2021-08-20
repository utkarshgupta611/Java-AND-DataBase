package com.ust.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;
import com.ust.util.JpaUtil;

public class EmployeeDaoJpaImpl implements EmployeeDao {

	@Override
	public Employee createEmp(Employee emp) throws EmployeeException {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeException {
		// using id
		EntityManager em = JpaUtil.getEntityManager();
		Employee emp = em.find(Employee.class, id);
		return emp;
	}

	@Override
	public Employee updateEmp(Employee updatedEmp) throws EmployeeException {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(updatedEmp); 
		em.getTransaction().commit();
		return updatedEmp;
	}

	@Override
	public List<Employee> getEmployee() throws EmployeeException {
		EntityManager em = JpaUtil.getEntityManager();
		String qry = "Select e from Employee e";
		Query querry = em.createQuery(qry);
		@SuppressWarnings("unchecked")
		List<Employee> eList = querry.getResultList();
		return eList;
	}

	@Override
	public Employee deleteEmp(int id) throws EmployeeException {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, id);
		em.remove(emp);
		return emp;
	}
}
