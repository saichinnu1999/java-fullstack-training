package com.capgemini.bankingmanagement.dao;

import com.capgemini.bankingmanagement.model.Account;

public interface IBankingDao {

	void addAccountDetails(Account account);
	Account getAccountByAccountNumber(Integer accountnumber);
}
