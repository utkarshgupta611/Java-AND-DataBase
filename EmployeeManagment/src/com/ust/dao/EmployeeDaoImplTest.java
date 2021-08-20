package com.ust.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;

public class EmployeeDaoImplTest {
	EmployeeDaoImpl eDao = new EmployeeDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateEmp() {
		// public EmployeeDao eDao;
		Employee emp = new Employee(0, "Sandeep", 9678423311l, "Trainee");

		try {
			Employee saved = eDao.createEmp(emp);
			// assertNotEquals(0, saved.getId());
			assertEquals(emp.getName(), saved.getName());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void testUpdateEmp() {

//	}

	@Test
	public void testGetEmployee() {
		try {
			Employee get = eDao.getEmployee(3);
			assertNotNull(get);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteEmp() {
	
	}
}
