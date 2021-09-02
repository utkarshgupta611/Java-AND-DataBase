package com.ust.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_table")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "cust_name")
	private String name;
	
	@Column(name = "cust_number")
	private long number;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int id, String name, long number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}
	public CustomerEntity(String name, long number) {
		super();
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", number=" + number + "]";
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

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
}
