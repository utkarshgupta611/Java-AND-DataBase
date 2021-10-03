package com.prvt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prvt.dao.PasswordDao;
import com.prvt.model.PasswordEntity;

@Service("pService")
public class PasswordServiceImpl implements PasswordService{

	@Autowired
	private PasswordDao pDao;
	
	//addPassword into Database
	@Override
	public PasswordEntity addPassword(PasswordEntity passEntity) {
		return pDao.save(passEntity);
	}

	//viewPassword into Database
	@Override
	public List<PasswordEntity> viewDetail() {
		return pDao.findAll();
	}

	//updatePassword into Database
	@Override
	public PasswordEntity updateDetail(PasswordEntity passEntity) {
		Optional<PasswordEntity> opt = pDao.findById(passEntity.getSerialNo());
		if(opt.isPresent())
		{
			PasswordEntity updates = opt.get();
			updates.copy(passEntity);
			pDao.save(updates);
			return updates;
		}
		return null;
	}

	//delete entry in Database
	@Override
	public PasswordEntity deleteEntry(Integer serialNo) {
		Optional<PasswordEntity> opt = pDao.findById(serialNo);
		if(opt.isPresent()) {
			PasswordEntity delEntry = opt.get();
			pDao.delete(delEntry);
			return delEntry;
		}
		return null;
	}

	@Override
	public PasswordEntity searchWeb(String website) {
		return pDao.findByWebsite(website);
	}

	@Override
	public PasswordEntity searchUser(String userName) {
		return pDao.findByUserName(userName);
	}

}


