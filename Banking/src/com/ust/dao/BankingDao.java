package com.ust.dao;

import com.ust.Exception.BankingException;

public interface BankingDao {

	double deposit(double amount);

	double getbalance();

	double withdraw(double debit) throws BankingException;


}
