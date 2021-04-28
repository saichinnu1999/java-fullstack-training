package com.capgemini.bankingmanagement.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.bankingmanagement.exception.InsufficientBalanceException;
import com.capgemini.bankingmanagement.exception.InsufficientOpeningBalanceException;
import com.capgemini.bankingmanagement.exception.InvalidAccountNumberException;
import com.capgemini.bankingmanagement.model.Account;
import com.capgemini.bankingmanagement.service.BankingServiceImpl;
import com.capgemini.bankingmanagement.service.IBankingService;


public class BankingManagementUI {

	public static Scanner scanner;
	
	public static IBankingService service= new BankingServiceImpl();
 
	
public static void main(String[] args) throws Exception {
		
		
		do {

			System.out.println("-----------Menu---------");
			System.out.println("1. Add account");
			System.out.println("2. Get Account");
			System.out.println("3. With Draw money");
			System.out.println("4. Deposit money");
			System.out.println("5. Transfer ");
			System.out.println("5. Exit");
		int input = 0;
		boolean inputFlag = false;
		
		int count=0;
		
		do {
			scanner = new Scanner(System.in);
			
			if(count>3) {
				System.exit(0);
			}
			System.out.println("enter ur input");
			try {
				input = scanner.nextInt();
				if(input == 1 || input == 2 || input == 3 || input == 4 || input == 5)
				{
					inputFlag = true;
				}
				else {
					inputFlag = false;
					System.err.println("Please enter valid option");
				}
			} catch (InputMismatchException e) {
				inputFlag = false;
				count++;
				System.err.println("input should contain only digits");
			}
			
		} while (!inputFlag);
		
		switch(input)
        {
        case 1 :  addAccount(); break;
        case 2 :  getAccount();break;
        case 3 :  withdraw(); break;
        case 4 :  depositmoney(); break;
        case 5 :  transfermoney(); break;
        case 6 :  { 
        				System.out.println("Thank you");
        	 			System.exit(0);
        	 	  };
        }
		
		} while(true);
		
	}

	static void addAccount() throws InsufficientOpeningBalanceException{
		 scanner = new Scanner(System.in);
		 Account account = new Account();
		 System.out.println("Enter Account Number : ");
		 account.setAccountNumber(scanner.nextInt());
		 if(service.getAccountByAccountNumber(account.getAccountNumber())!=null) {
			 System.err.println("Account on this number already exist");
		}
		 else {
		 System.out.println("Enter Balance : ");
		 account.setBalance(scanner.nextLong());
		 try {
		 if(account.getBalance()<500) {
			 throw new InsufficientOpeningBalanceException("Insufficient Opening Balance Exception");
		 }
		 else {
		 service.addAccountDetails(account);
		 System.out.println("Account added..");
		 }
		 }
		 catch (InsufficientOpeningBalanceException e) {
			System.err.println(e.getMessage());
		}
	
		 }
		
	}
	private static void transfermoney() throws InvalidAccountNumberException,InsufficientBalanceException{
		System.out.println("Enter Your Account Number : ");
		int accountNumber1 = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber1);
		try{if(account != null) {
			System.out.println("Enter Account Number to whom you want to transfer: ");
			int accountNumber2 = scanner.nextInt();
			Account account1 = service.getAccountByAccountNumber(accountNumber2);
			if(account1 != null) {
				System.out.println("Enter Transferring Amount : ");
				long transfer= scanner.nextLong();
				if(account.getBalance()<transfer) {
					 throw new InsufficientBalanceException("Insufficient balance");
				}
				else
				{
					long s;
					long p;
				    s=account.getBalance()-transfer;
				    p=account1.getBalance()+transfer;
				    account.setBalance(s);
				    account1.setBalance(p);
				    System.out.println("Balance left in your Account after tranfering "+ account.getBalance());
				}
			}
			else {
				throw new InvalidAccountNumberException("Account not found");
			}
			
		}
		else
		{
			throw new InvalidAccountNumberException("Account not found");
		}
		}
		catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}
		catch (InsufficientBalanceException e) {
			System.err.println(e.getMessage());
		}
		
	}
	private static void depositmoney() throws InvalidAccountNumberException {
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try{if(account != null) {
			System.out.println("Enter deposital Amount : ");
			long deposit= scanner.nextLong();
				long s;
				s=account.getBalance()+deposit;
				account.setBalance(s);
				System.out.println("Balance after adding money in Account "+ account.getBalance());		
			
		}
		else {
			throw new InvalidAccountNumberException("Account not found");
		}
		}
		catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}
	}


	private static void withdraw() throws InvalidAccountNumberException,InsufficientBalanceException {
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try{if(account != null) {
			System.out.println("Enter Withdrawal Amount : ");
			long withdrawal= scanner.nextLong();
			if(account.getBalance()<withdrawal) {
				throw new InsufficientBalanceException("Insufficient balance");
			}
			else
			{
				long s;
				s=account.getBalance()-withdrawal;
				account.setBalance(s);
				System.out.println("Balance left in Account "+ account.getBalance());
			}
			
		}
		else {
			throw new InvalidAccountNumberException("Account not found");
		}
		}
		catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}
		catch (InsufficientBalanceException e) {
			System.err.println(e.getMessage());
		}
	}


   static void getAccount() throws InvalidAccountNumberException {
	 scanner = new Scanner(System.in);
		System.out.println("Enter Account Number : ");
		int accountNumber = scanner.nextInt();
		Account account = service.getAccountByAccountNumber(accountNumber);
		try{
			if(account != null) {
		
		System.out.println("Account Details");
		System.out.println("-----------------------------------");
		System.out.println("Account Number               "+ account.getAccountNumber());
		System.out.println("Balance                     "+ account.getBalance());
		}
		else {
			throw new InvalidAccountNumberException("Account not found");
		}
    }
		catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
		}
		
	} 
	
}

