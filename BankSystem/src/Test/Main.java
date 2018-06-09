package Test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dao.AccountDao;
import com.mapper.AccountMapper;
import com.mapper.EmployeeMapper;
import com.model.Account;
import com.model.Employee;

public class Main {
	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml"); 
		SqlSessionFactory factory=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		SqlSession session=factory.openSession();
		try{
			AccountMapper am=session.getMapper(AccountMapper.class);
			Account account=am.getAccountById("01");
			System.out.println(account);
			
		}finally{
			session.close();
		}
		
	}

}
