package com.prvt.service;

import java.util.List;

import com.prvt.model.PasswordEntity;

public interface PasswordService {

	PasswordEntity addPassword(PasswordEntity passEntity);

	List<PasswordEntity> viewDetail();

	PasswordEntity updateDetail(PasswordEntity passEntity);

	PasswordEntity deleteEntry(Integer serialNo);

	PasswordEntity searchWeb(String website);

	PasswordEntity searchUser(String userName);

}
