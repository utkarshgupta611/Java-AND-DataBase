package com.ust.main;

import java.util.Scanner;

import com.ust.Exception.BankingException;
import com.ust.service.BankingService;
import com.ust.service.BankingServiceImplementation;

public class BankingMain {

	private BankingService bService;

	private void execute() throws BankingException {
		// Execute_Method
		bService = new BankingServiceImplementation();
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		int choise = 0;
		while (!stop) {

			choise = getChoise(sc);
			switch (choise) {
			case 1: 
				System.err.println("1. Deposit");
				System.out.println("                    ");
				double amount = 0;
//				try {} ----- ? question 
				System.out.println("Please enter The Amount to be deposite  -- > ");
				amount = sc.nextDouble();
				double balance = bService.deposite(amount);
				System.out.println("------------------------------------------------");
				System.out.println("the amount is deposited, ur balance is " + balance);
				System.out.println("------------------------------------------------");
				break;

			case 2:
				System.err.println("2. Withdraw Amount");
				System.out.println("                    ");
				double debit = 0;
				debit = sc.nextDouble();

				try {
					balance = bService.withdraw(debit);
					System.out.println("------------------------------------------------");
					System.out.println(" * Amount Withdrawing     ->  " + debit);
					System.out.println(" * your Remaining Balance ->  " + balance);
					System.out.println("------------------------------------------------");
				} catch (BankingException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				System.err.println("3. Check balance");
				System.out.println("                    ");
				balance = bService.getbalance();
				System.out.println("------------------------------------------------");
				System.out.println("Your Balance = " + balance);
				System.out.println("------------------------------------------------");
				break;

			case 4:
				System.err.println("Thank you for visiting");
				System.err.println("UST Bank");
				System.out.println("                    ");
				stop = true;
				break;

			default:
				System.err.println("Please Enter number from 1 - 4");
				break;
			}
		}
		sc.close();
	}

	// Method
	private int getChoise(Scanner sc) {
		int choise = 0;
		System.out.println("Welcome to UST Bank");
		System.out.println("1. Deposite");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Check balance");
		System.out.println("4. Exit System");
		System.out.println("Please inter number between 1 to 4");
		choise = sc.nextInt();
		return choise;
	}

	// MAIN
	public static void main(String[] args) throws BankingException {
		new BankingMain().execute();

	}

}