package com.prvt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prvt.model.PasswordEntity;

public interface PasswordDao extends JpaRepository<PasswordEntity, Integer> {

	PasswordEntity findByWebsite(String website);

	PasswordEntity findByUserName(String userName);

}
