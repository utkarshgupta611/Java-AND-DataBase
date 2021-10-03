package com.prvt.model;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "PasswordEntity")
public class PasswordEntity {
	
	@Id
	@GeneratedValue
	private Integer serialNo;
	private String website;
	private String userName;
	private String password;
	
// --------------- * --------------- * --------------- Constructor --------------- * --------------- * ---------------
	public PasswordEntity() {
	}

	public PasswordEntity(Integer serialNo, String website, String userName, String password) {
		super();
		this.serialNo = serialNo;
		this.website = website;
		this.userName = userName;
		this.password = password;
	}
// --------------- * --------------- * --------------- Getter And Setter --------------- * --------------- * ---------------

	public Integer getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PasswordEntity [serialNo=" + serialNo + ", website=" + website + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	// --------------- * --------------- * --------------- Copy Method --------------- * --------------- * ---------------
	public void copy(PasswordEntity passEntity) {
		this.website = passEntity.getWebsite();
		this.userName = passEntity.getUserName();
		this.password = passEntity.getPassword();
		
	}
	
}
