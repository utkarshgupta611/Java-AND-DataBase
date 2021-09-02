package com.ust.jpasingle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MGR") 
public class Manager1 extends Employee {
	
	private String dept;
    
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager [dept=" + dept + "]";  
	}

}
