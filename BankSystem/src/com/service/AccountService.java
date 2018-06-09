package com.service;

import java.util.List;

import com.model.Account;

public interface AccountService {
	//转钱
	public void transferMoney(String sourceAccoutnId,String targetAccountId,double amount);
	
	//存钱
	public void  saveMoney(String accountId,double amount);
	
	public Account getAccount(String accountId);
	
	public Integer addAccount(Account account);
	
	public Integer saveAccount(Account account);
	
	public Integer updateAccount(Account account);
	
	public List<Account> getAllAccounts();
	
	
	
	public Integer deleteAccounts(List<String> ids);

	public List<Account> getPageAccounts(Account account,int start,int rows,String sort,String order);

}
