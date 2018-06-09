package com.service;

import java.util.List;

import com.model.Resource;

public interface TreeService {
	
	public List<Resource> getChildrenByParentId(Integer id);

}
