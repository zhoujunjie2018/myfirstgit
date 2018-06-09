package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.AccountMapper;
import com.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
	public SqlSessionFactory getFactory(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml"); 
		SqlSessionFactory factory=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		return factory;
	}
	
	
	@Override
	public Account findById(String id) {
		SqlSession sqlSession=getFactory().openSession();
		try{
			AccountMapper am=sqlSession.getMapper(AccountMapper.class);
			Account account=am.getAccountById(id);

			return account;
		}finally{
			sqlSession.close();
		}
		
	}

//更新
	@Override
	public Integer updateAccount(Account account) {
		SqlSession sqlSession=getFactory().openSession();
		try{
			
			AccountMapper am=sqlSession.getMapper(AccountMapper.class);
			Integer i=am.updateA(account);
			sqlSession.commit();
			
			return i;
		}finally{
			sqlSession.close();
		}
		
		
		
	}


	@Override
	public Integer addAccount(Account account) {
		SqlSession sqlSession=getFactory().openSession();
	try{
			
			AccountMapper am=sqlSession.getMapper(AccountMapper.class);
			Integer i=am.addAccount(account);
			sqlSession.commit();
			return i;
		}finally{
			sqlSession.close();
		}
		
		
	}


	@Override
	public List<Account> getPageAccounts(Account account,int start,int rows,String sort,String order) {
		
		SqlSession sqlSession=getFactory().openSession();
		try{
				
				AccountMapper am=sqlSession.getMapper(AccountMapper.class);
				List<Account> accounts=am.getPageAccounts(account, start,rows,sort,order);
				return accounts;
			}finally{
				sqlSession.close();
			}
	}


	@Override
	public List<Account> getAllAccounts() {
		SqlSession sqlSession=getFactory().openSession();
		try{
				
				AccountMapper am=sqlSession.getMapper(AccountMapper.class);
				List<Account> accounts=am.getAllAccounts();
				return accounts;
			}finally{
				sqlSession.close();
			}
	}


	@Override
	public Integer saveAccount(Account account) {
		SqlSession sqlSession=getFactory().openSession();
		try{
				
				AccountMapper am=sqlSession.getMapper(AccountMapper.class);
				Integer i=am.saveAccount(account);
				sqlSession.commit();
				return i;
			}finally{
				sqlSession.close();
			}
			
	}


	@Override
	public Integer deleteAccounts(List<String> ids) {
		SqlSession sqlSession=getFactory().openSession();
		try{
				
				AccountMapper am=sqlSession.getMapper(AccountMapper.class);
				Integer i=am.deleteAccounts(ids);
				sqlSession.commit();
				return i;
			}finally{
				sqlSession.close();
			}
	}

}
