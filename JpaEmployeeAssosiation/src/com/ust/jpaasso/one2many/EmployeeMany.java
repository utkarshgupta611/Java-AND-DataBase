package com.ust.jpaasso.one2many;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_hib_asso2many")
public class EmployeeMany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private long mobile;
	
@ManyToOne
@JoinColumn(name="dept_id")
	private DepartmentOne dept;

public EmployeeMany() {
}

public EmployeeMany(int id, String name, long mobile, DepartmentOne dept) {
	this.name = name;
	this.mobile = mobile;
	this.dept = dept;
}
//override
public EmployeeMany( String name, long mobile, DepartmentOne dept) {
	this.name = name;
	this.mobile = mobile;
	this.dept = dept;
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

public DepartmentOne getDept() {
	return dept;
}

public void setDept(DepartmentOne dept) {
	this.dept = dept;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", mobile=" + mobile + ", dept=" + dept + "]";
}
}
