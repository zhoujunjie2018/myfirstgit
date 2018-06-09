package com.dao;

import java.util.List;

import com.model.Account;

public interface AccountDao {
	
	public Account findById(String id);
	
	public Integer updateAccount(Account account);
	
	public Integer addAccount(Account account);
	
	public  Integer saveAccount(Account account);
	
	public Integer deleteAccounts(List<String > ids);
	
	public List<Account> getAllAccounts();
	
	public List<Account> getPageAccounts(Account account,int start,int rows,String sort,String order);

}
