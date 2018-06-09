package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountDao;
import com.model.Account;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Override
	public void transferMoney(String sourceAccountId, String targetAccountId,double amount) {
		Account sourceAccount=getAccount(sourceAccountId);
		Account targetAccount=getAccount(targetAccountId);
		sourceAccount.setBalance(sourceAccount.getBalance()-amount);
		targetAccount.setBalance(targetAccount.getBalance()+amount);
		accountDao.updateAccount(sourceAccount);
		accountDao.updateAccount(targetAccount);

	}

	@Override
	public void saveMoney(String accountId, double amount) {
		Account account=getAccount(accountId);
		account.setBalance(account.getBalance()+amount);
		accountDao.updateAccount(account);
		

	}

	@Override
	public Account getAccount(String accountId) {
		
		return accountDao.findById(accountId);
	}

	@Override
	public Integer addAccount(Account account) {
		Integer i=accountDao.addAccount(account);
		return i;
		
	}

	@Override
	public List<Account> getPageAccounts(Account account,int start,int rows,String sort,String order) {
		List<Account> accounts=accountDao.getPageAccounts(account, start, rows, sort, order);
		return accounts;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts=accountDao.getAllAccounts();
		return accounts;
	}

	@Override
	public Integer saveAccount(Account account) {
		Integer i=accountDao.saveAccount(account);
		return i;
	}

	@Override
	public Integer updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public Integer deleteAccounts(List<String> ids) {
		return accountDao.deleteAccounts(ids);
	}

	

	
}
