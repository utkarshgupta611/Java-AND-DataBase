package com.ust.service;

import java.util.List;

import com.ust.dao.EmployeeDao;
//import com.ust.dao.EmployeeDaoImpl;
import com.ust.dao.EmployeeDaoJpaImpl;
import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao eDao;

	@Override
	public Employee createEmp(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		return eDao.createEmp(emp);
	}

	public EmployeeServiceImpl() {
//		eDao = new EmployeeDaoImpl();
		eDao = new EmployeeDaoJpaImpl();
	}

	@Override
	public Employee getEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return eDao.getEmployee(id);
	}

	@Override
	public Employee updateEmp(Employee updatedEmp) throws EmployeeException {
		// TODO Auto-generated method stub
		return eDao.updateEmp(updatedEmp);
	}

	@Override
	public List<Employee> getEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return eDao.getEmployee();
	}

	@Override
	public Employee deleteEmp(int id1) throws EmployeeException {
		// TODO Auto-generated method stub
		return eDao.deleteEmp(id1);
	}

}
