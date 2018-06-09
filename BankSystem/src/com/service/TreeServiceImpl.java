package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TreeDao;
import com.model.Resource;

@Service
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	private TreeDao treeDao;

	@Override
	public List<Resource> getChildrenByParentId(Integer id) {
		
		 return treeDao.getChildrenByParentId(id);
	}

}
