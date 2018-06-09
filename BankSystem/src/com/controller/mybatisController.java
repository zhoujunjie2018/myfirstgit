package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class mybatisController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("select")
	public String toSelect(){
		return "select";
	}
	
	@RequestMapping("getemps")
	public String emps(Map<String,Object> map){
		List<Employee> emps=employeeService.getEmps();
		map.put("allemps", emps);
		
		return "list";
		
	}
	
	@RequestMapping("selectById")
	public String select(HttpServletRequest req,Model model){
		String sid=req.getParameter("id");
		Integer id=Integer.parseInt(sid);
		Employee emp=employeeService.getEmpById(id);
		model.addAttribute("e", emp);
		
		return "showSelect";
	}
	
	/*@RequestMapping("selectId")
	@ResponseBody
	public ResponseEntity<Employee> selectId(int id){
		Employee emp=employeeService.getEmpById(id);
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}*/
	
	@RequestMapping("selectId")
	@ResponseBody
	public Employee selectId(int id){
		Employee emp=employeeService.getEmpById(id);
		
		return emp;
	}
	
	

}
