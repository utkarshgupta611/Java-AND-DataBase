package com.ust.service;

import com.ust.Exception.BankingException;
import com.ust.dao.BankingDao;
import com.ust.dao.BankingDaoImpl;

public class BankingServiceImplementation implements BankingService {
	private BankingDao bDao;

	@Override
	public double deposite(double amount) {
		// TODO Auto-generated method stub
		return bDao.deposit(amount);
	}

	public BankingServiceImplementation() {
		super();
		bDao = new BankingDaoImpl();
	}

//	@Override
//	public double get(double status) {
//		// TODO Auto-generated method stub
//		return bDao.get(status);
//	}
	@Override
	public double getbalance() {
		// TODO Auto-generated method stub
		return bDao.getbalance();
	}

	@Override
	public double withdraw(double debit) throws BankingException {
		// TODO Auto-generated method stub
		return bDao.withdraw(debit); 
		
	}



}
