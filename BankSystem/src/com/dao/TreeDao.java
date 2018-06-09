package com.dao;

import java.util.List;

import com.model.Resource;

public interface TreeDao {
	
	public List<Resource> getChildrenByParentId(Integer id);

}
