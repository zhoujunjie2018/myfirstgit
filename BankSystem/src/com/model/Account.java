package com.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	private String id;
	private String ownerName;
	private Double balance;
	private Date  startAccessTime;
	private Date  endAccessTime;
	private String password;
	private Integer sex;
	
	
	


	
	

	public Date getStartAccessTime() {
		return startAccessTime;
	}
	public void setStartAccessTime(Date startAccessTime) {
		this.startAccessTime = startAccessTime;
	}
	public Date getEndAccessTime() {
		return endAccessTime;
	}
	public void setEndAccessTime(Date endAccessTime) {
		this.endAccessTime = endAccessTime;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
//	public String getAccessTime() {
//		
//		return accessTime;
//	}
//	public void setAccessTime(String accessTime){
//		
//	    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
//	    this.accessTime = accessTime;
//	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", ownerName=" + ownerName + ", balance="
				+ balance + ", startAccessTime=" + startAccessTime
				+ ", endAccessTime=" + endAccessTime + ", password=" + password
				+ ", sex=" + sex + "]";
	}
	
	

}
