package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.EmployeeMapper;
import com.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper empMapper;
	
	public List<Employee> getEmps(){
		List<Employee> list=empMapper.getEmps();
		return list;
	}
	
	public Employee getEmpById(Integer id){
		Employee emp= empMapper.getEmpById(id);
		return emp;
	}
}
