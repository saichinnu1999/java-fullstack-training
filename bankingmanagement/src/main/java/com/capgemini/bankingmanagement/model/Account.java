package com.capgemini.bankingmanagement.model;

public class Account {

	private int accountNumber;
	private long balance;
	
	
	
	public Account() {
		
	}
	public Account(int accountNumber, long balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
}
