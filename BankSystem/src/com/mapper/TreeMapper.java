package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Resource;

public interface TreeMapper {
	
	public List<Resource> getChildrenByParentId(@Param("id")Integer id);

}
