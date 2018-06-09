package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Employee;

public interface EmployeeMapper {
	
	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	

	
	

}
