package com.ust.jpaasso.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept_hib_asso2many")
public class DepartmentOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "dept" ,cascade = CascadeType.ALL)
	private Set<EmployeeMany> employees = new HashSet<>();

	public DepartmentOne() {
	}

	public DepartmentOne(String name, Set<EmployeeMany> employees) {
		this.name = name;
		this.employees = employees;
	}
	public DepartmentOne(String name) {
		this.name = name;

	}

	public DepartmentOne(int id, String name, Set<EmployeeMany> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public void addEmployee(EmployeeMany emp) {
		emp.setDept(this);
		employees.add(emp);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeMany> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeMany> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	} 
}
