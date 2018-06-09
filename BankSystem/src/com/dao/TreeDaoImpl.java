package com.dao;

import java.util.List;






import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.mapper.TreeMapper;
import com.model.Resource;

@Repository
public class TreeDaoImpl implements TreeDao {
	
	public SqlSessionFactory getSessionFactory(){
		ApplicationContext ac=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		SqlSessionFactory factory=ac.getBean(SqlSessionFactory.class);
		return factory;
		
	}
	
	

	@Override
	public List<Resource> getChildrenByParentId(Integer id) {
		SqlSession sqlSession=getSessionFactory().openSession();
		
		try{
			TreeMapper tm=sqlSession.getMapper(TreeMapper.class);
			List<Resource> rlist=tm.getChildrenByParentId(id);
			
			
			return rlist;
		}finally{
			sqlSession.close();
		}
		
	}

}
