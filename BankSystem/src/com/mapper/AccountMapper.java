package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Account;

public interface AccountMapper {
	public Account getAccountById(String id);
	public Integer updateA(Account account);
	
	public  Integer addAccount(Account account);
	
	public Integer saveAccount(Account account);
	
	public Integer deleteAccounts(@Param("ids")List<String> ids);
	
	public  List<Account> getAllAccounts();
	
	public List<Account> getPageAccounts(@Param("account")Account account,
			@Param("start")int start,@Param("rows")int rows,@Param("sort")String sort,@Param("order")String order);

}
