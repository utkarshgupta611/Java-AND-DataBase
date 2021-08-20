package com.ust.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;
import com.ust.exception.Message;
import com.ust.util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private Logger logger = Logger.getLogger(EmployeeDaoImpl.class);

	// Create employee
	@Override
	public Employee createEmp(Employee emp) throws EmployeeException {
		logger.info(emp);
		Connection conn = DBUtil.getConnection();
		String query = "insert into  Emp_record(name,mobile,designation) values(?,?,?)";
		String autoIncrQuery = "select auto_increment from information_schema.tables where table_name='emp_record'";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(autoIncrQuery);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				emp.setId(id);
				logger.info("id: " + id);
				stmt = conn.prepareStatement(query);
				stmt.setString(1, emp.getName());
				stmt.setLong(2, emp.getMobile());
				stmt.setString(3, emp.getDesignation());
				int rows = stmt.executeUpdate();
				if (rows <= 0) {
					return null;
				}
			} else {
				// do something
			}
		} catch (SQLException e) {
			logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return emp;
	}

	// update employee
	@Override
	public Employee getEmployee(int id) throws EmployeeException {
		logger.info("id: " + id);
		Employee emp = null;
		String SelectQuerry = "select name,mobile,designation from emp_record where id=?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SelectQuerry);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				emp = new Employee(id, rs.getNString(1), rs.getLong(2), rs.getString(3));
				System.out.println();
			} else {
				// lets see in future
			}

		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e);
			throw new EmployeeException(Message.DATABASE_ERROR);
		}

		return emp;
	}

	// Update
	@Override
	public Employee updateEmp(Employee updatedEmp) throws EmployeeException {
		Employee emp = null;
		logger.info(updatedEmp);
		String query = "update emp_record set mobile=?, designation=? where id=?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setLong(1, updatedEmp.getMobile());
			stmt.setString(2, updatedEmp.getDesignation());
			stmt.setInt(3, updatedEmp.getId());
			int rows = stmt.executeUpdate();
			if (rows > 0) {
				emp = updatedEmp.getCopy();// gives a safe object as copy
			} else {
				throw new EmployeeException(Message.UPDATE_FAILED);
				// send email message to developer
			}

		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e);
			throw new EmployeeException(Message.DATABASE_ERROR);
		}

		return emp;
	}

	// Display all Employee
	@Override
	public List<Employee> getEmployee() throws EmployeeException {
		List<Employee> empList = new ArrayList<>();
		String DisplayQuerry = "select  id ,name, mobile ,designation  from emp_record";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DisplayQuerry);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4));
				empList.add(emp);
				// alwayss return emp list from dao layer never return sout from dao
//				System.out.printf("%-5s %-12s %-20s %-5s", rs.getInt(1), rs.getString(2), rs.getLong(3),rs.getString(4));					
//				System.out.println();
			}
		} catch (EmployeeException e) {
			logger.error(e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e);
			throw new EmployeeException(Message.DATABASE_ERROR);
		}
		return empList;
	}

	// Delete the emp Data
	@Override
	public Employee deleteEmp(int id1) throws EmployeeException {
		Employee emp = null;
		String DeleteQuerry = "DELETE FROM emp_record WHERE id=?";
		try {
//			emp = getEmployee();
			Connection conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DeleteQuerry);
			stmt.setInt(1, id1);
//			ResultSet rs = stmt.executeQuery();
			int rows = stmt.executeUpdate();
			if (rows == 0) {
				throw new EmployeeException(Message.DELETE_FAILED);
			} else {
				emp = new Employee();

			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
			throw new EmployeeException(Message.DATABASE_ERROR);
		}
		return emp;
	}

}

/*
 * 1. Add driver (jar) to lib and build path 
 * 2. Load the driver class 
 * 3. Get connection using Driver Manager Class 
 * 4. Create Statement using connection 
 * 5.Execute the Querry using ResultSet 
 * 6. Run while loop to get all row (while select)
 */

// ERROR
// database error - "Error in Database. Please report to DBA"