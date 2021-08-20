package com.ust.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ust.entity.Employee;
import com.ust.exception.EmployeeException;
import com.ust.service.EmployeeService;
import com.ust.service.EmployeeServiceImpl;

public class EmployeeUI {
	private EmployeeService eService;

	public void start() {
		eService = new EmployeeServiceImpl();
		Scanner scan = new Scanner(System.in);

		// While
		boolean canrun = true;
		int choice = 0; // User Choice
		while (canrun) {
			choice = getchoice(scan);
			switch (choice) {
			case 1:
				System.err.println("Create an Employee Record");
				Employee emp = null;
				System.out.println(" ENTER <Name> <Mobile> <Designation> ");
				emp = new Employee(0, scan.next(), scan.nextLong(), scan.next());

				Employee savedEmp;
				try {
					savedEmp = eService.createEmp(emp);
					if (savedEmp != null) {
						System.out.println(" Employee Record Created Successfully ");
					} else {
						System.out.println(" Failed to create record ");
						System.out.println(savedEmp);
					}
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 2:
				System.err.println("Update an Employee");
				System.out.println("Enter ID of employee to update");
				int id = scan.nextInt();
				try {
					emp = eService.getEmployee(id);
					if (emp != null) {
						System.out.println(emp);
						System.out.println("Enter <mobile> <designation> to update");
						Employee updatedEmp = new Employee(id, emp.getName(), scan.nextLong(), scan.next());
						emp = eService.updateEmp(updatedEmp);
						if (emp != null) {
							System.out.println("Updated: " + emp);
						} else {
							System.out.println("Failed to updated Record");
						}
					}
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Delete an Employee");
				System.out.println("Type <Id>  to delete the employ from database");
				int id1 = scan.nextInt();
				try {
					emp = eService.deleteEmp(id1);
				} catch (EmployeeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				break;
			case 4:
				System.out.println("Display all Employee");
				try {
					List<Employee> empList = eService.getEmployee();
//					System.out.println(empList);
					print(empList);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("Display an per Employee");
				System.out.println("Enter id to display the record");
				id = scan.nextInt();
				try {
					emp = eService.getEmployee(id);
					System.out.println(emp);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.err.println("Thank you. /n Exiting system.");
				canrun = false;
				scan.close();
				break;

			default:
				System.err.println("Please enter 1 to 5 only");
				break;
			}

		}

	}

	private void print(List<Employee> empList) {
		System.out.println("ID      NAME         MOBILE            DESIGNATION  ");
		for (Employee employee : empList) {
//			System.out.println(employee);
			System.out.printf("\n%-5s" + "|" + "%-12s" + "|" + "%-20s" + "|" + " %-5s\n", employee.getId(),
					employee.getName(), employee.getMobile(), employee.getDesignation());
			System.out.println();
		}

	}

	private int getchoice(Scanner scan) {
		int choice = 0;
		System.out.println("Welcome to Employee Management System");
		System.out.println("1. Create an Employee Record");
		System.out.println("2. Update an Employee");
		System.out.println("3. Delete an Employee");
		System.out.println("4. Display all Employee");
		System.out.println("5. Display as per ID");
		System.out.println("6. Exit System");
		System.out.println("Please enter your choice 1 to 5");

		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Please enter numbers only");
			scan.nextLine();
		}
		return choice;
	}

	// Main Class ----> Start
	public static void main(String[] args) {
		new EmployeeUI().start();

	}

}
