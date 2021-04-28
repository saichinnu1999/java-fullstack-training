package com.capgemini.bankingmanagement.service;

import com.capgemini.bankingmanagement.dao.BankingDaoImpl;
import com.capgemini.bankingmanagement.dao.IBankingDao;
import com.capgemini.bankingmanagement.model.Account;

public class BankingServiceImpl implements IBankingService {

	private IBankingDao dao= new BankingDaoImpl();
	@Override
	public void addAccountDetails(Account account) {
		
		dao.addAccountDetails(account);
	}

	@Override
	public Account getAccountByAccountNumber(Integer accountnumber) {
		return dao.getAccountByAccountNumber(accountnumber);
	}

}
