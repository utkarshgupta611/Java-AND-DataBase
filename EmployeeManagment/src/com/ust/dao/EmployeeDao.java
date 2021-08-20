package com.ust.dao;

import java.util.List;

import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;

public interface EmployeeDao {

	Employee createEmp(Employee emp) throws EmployeeException;

	Employee getEmployee(int id) throws EmployeeException;

	Employee updateEmp(Employee updatedEmp) throws EmployeeException;

	List<Employee> getEmployee() throws EmployeeException;

	Employee deleteEmp(int id1) throws EmployeeException;

}
