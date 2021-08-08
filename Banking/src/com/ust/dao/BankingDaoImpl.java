package com.ust.dao;

import com.ust.Exception.BankingException;

public class BankingDaoImpl implements BankingDao {
	private double balance = 1000;
	private static final double MinBalance = 1000;

	@Override
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}

	@Override
	public double getbalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	@Override
	public double withdraw(double debit) throws BankingException {
		balance -= debit;
		if(balance < MinBalance) {
			throw new BankingException("Insufficient Balance");
			}
		return balance;
	}
}