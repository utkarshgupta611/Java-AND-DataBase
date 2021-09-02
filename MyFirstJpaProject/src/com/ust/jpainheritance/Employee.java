package com.ust.jpainheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table(name = "employee_hib")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
//
//@Id
//@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private long mobile;
public Employee() {
	}
public Employee(int id, String name, long mobile) {
	super();
	this.id = id;
	this.name = name;
	this.mobile = mobile;
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
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
}

}
