package com.ust.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
- create table Emp_record(id int(5) primary key auto_increment, name varchar(25),
  mobile bigint, designation varchar(20));
- alter table emp_record auto_increment=10001;
 */
@Entity
@Table(name = "Emp_jpa")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobile;
	private String designation;
	public Employee() {
	}
	public Employee(int id, String name, long mobile, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.designation = designation;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mobile=" + mobile + ", designation=" + designation + "]";
	}
	public Employee getCopy() {
		Employee copy = null;
		copy = new Employee(id, name, mobile, designation);
		return copy;
	}
	

}
