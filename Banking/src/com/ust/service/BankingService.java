package com.ust.service;

import com.ust.Exception.BankingException;

public interface BankingService {

	double deposite(double amount);

	double getbalance();

	double withdraw(double debit) throws BankingException;

}
