package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Account;
import com.model.Json;
import com.service.AccountServiceImpl;


@Controller
public class AccountController {
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@RequestMapping("tree")
	public String tree(){
		return "01_tree";
	}
	
	
	@RequestMapping("login")
	public String toLogin(){
		return "accountLogin";
	}
	
	@RequestMapping("accountIndex")
	public String accountIndex(){
		return "accountIndex";
	}
	
	@RequestMapping("accountLogin")
	@ResponseBody
	public Json login(HttpServletRequest req){
		String id=req.getParameter("id");
		Account account=accountServiceImpl.getAccount(id);
		Json json=new Json();
		if(account!=null){
			json.setSuccess(true);
			json.setMsg("登陆成功");
			json.setObj(account);
			
		}else{
			json.setMsg("用户账号或者密码错误");
		}
		return json;
	}
	
	@RequestMapping("addAccount")
	@ResponseBody
	public Json addAccount(Account account,HttpServletRequest req){
		Integer i=accountServiceImpl.addAccount(account);
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(account);
		Json json=new Json();
		if(i!=0){
			json.setSuccess(true);
			json.setMsg("注册成功");
			json.setObj(accounts);
			
		}else{
			json.setMsg("用户账号或者密码错误");
		}
		return json;
	}
	
	@RequestMapping("saveAccounta")
	@ResponseBody
	public Json saveAccount2(Account account) throws ParseException{
		
	
		Integer i=accountServiceImpl.saveAccount(account);
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(account);
		Json json=new Json();
		if(i!=0){
			json.setSuccess(true);
			json.setMsg("保存成功");
			json.setObj(accounts);
			
		}else{
			json.setMsg("保存失败");
		}
		return json;
	}
	
//	@RequestMapping("saveAccount")
//	@ResponseBody
//	public Json saveAccount(HttpServletRequest req) throws ParseException{
//		
//		String id=req.getParameter("id");
//		String ownerName=req.getParameter("ownerName");
//		String password=req.getParameter("password");
//		String balance1=req.getParameter("balance");
//		Double balance=null;
//		if(balance1!=null && !balance1.equals("")){
//			balance=Double.parseDouble(balance1);
//			
//		}
//		
//		Integer sex=Integer.parseInt(req.getParameter("sex"));
//		String accessTime1=req.getParameter("accessTime");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date accessTime=sdf.parse(accessTime1);
//		Account account=new Account();
//		account.setId(id);
//		account.setOwnerName(ownerName);
//		account.setPassword(password);
//		account.setBalance(balance);
//		account.setAccessTime(accessTime);
//		account.setSex(sex);
//		Integer i=accountServiceImpl.saveAccount(account);
//		List<Account> accounts=new ArrayList<Account>();
//		accounts.add(account);
//		Json json=new Json();
//		if(i!=0){
//			json.setSuccess(true);
//			json.setMsg("保存成功");
//			json.setObj(accounts);
//			
//		}else{
//			json.setMsg("保存失败");
//		}
//		return json;
//	}
	
	@RequestMapping("updateAccount")
	@ResponseBody
	public Json updateAccount(Account account,HttpServletRequest req){
		Integer i=accountServiceImpl.updateAccount(account);
		List<Account> accounts=new ArrayList<Account>();
		accounts.add(account);
		Json json=new Json();
		if(i!=0){
			json.setSuccess(true);
			json.setMsg("更新成功");
			json.setObj(accounts);
			
		}else{
			json.setMsg("更新失败");
		}
		return json;
	}
	
	
	@RequestMapping("deleteAccounts")
	@ResponseBody
	public Json deleteAccounts(HttpServletRequest req){
		String ids=req.getParameter("ids");
		String[] idsarr=ids.split(",");
		List<String> idlist=Arrays.asList(idsarr);
		Integer i=accountServiceImpl.deleteAccounts(idlist);
		
		
		Json json=new Json();
		if(i!=0){
			json.setSuccess(true);
			json.setMsg("删除成功");
			
			
		}else{
			json.setMsg("删除失败");
		}
		return json;
	}
	
	
	
	
	@RequestMapping("getAccounts")
	@ResponseBody
	public ResponseEntity<Map<String,Object>> getAccounts(HttpServletRequest req,int page,int rows,String sort,String order ) throws ParseException{
		String ownerName=req.getParameter("ownerName");
		String startAccessTime1=req.getParameter("startAccessTime");
		String endAccessTime1=req.getParameter("endAccessTime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
	
		
		Account account=new Account();
		if(ownerName !=null && ownerName!=""){
			account.setOwnerName(ownerName);
		}
		if(startAccessTime1 !=null && startAccessTime1 !=""){
			Date startAccessTime=sdf.parse(startAccessTime1);
					
			account.setStartAccessTime(startAccessTime);
		}
		if(endAccessTime1 !=null && endAccessTime1 !=""){
			Date endAccessTime=sdf.parse(endAccessTime1);
					
			account.setEndAccessTime(endAccessTime);
		}
		
		int start=(page-1)*rows;

		List<Account> accounts=accountServiceImpl.getPageAccounts(account, start, rows,sort,order);
		
		List<Account> as=accountServiceImpl.getAllAccounts();
		int total=as.size();
		
		Map<String ,Object> map=new HashMap<String, Object>();
		
		map.put("rows", accounts);
		map.put("total", total);
		return new  ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}



//@RequestMapping(
//    value="getAccounts", 
//    method=RequestMethod.POST, 
//    consumes="application/json")
//	@ResponseBody
//	public ResponseEntity<List<Account>> getAccounts(@RequestBody Account account) throws ParseException{
//		
//		List<Account> accounts=accountServiceImpl.getAccounts(account);
//		return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
//	}
//
}


