package com.ust.jpainheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="manager_hib")
public class Manager extends Employee {
private String dept;

public String getDept() {
	return dept;
}

public void setDept(String dept) {
	this.dept = dept;
}

@Override
public String toString() {
	return super.toString() + "Manager [dept=" + dept + "]"; // 
}

}
