package com.capgemini.bankingmanagement.service;

import com.capgemini.bankingmanagement.model.Account;

public interface IBankingService {

	void addAccountDetails(Account account);
	Account getAccountByAccountNumber(Integer accountnumber);
}

