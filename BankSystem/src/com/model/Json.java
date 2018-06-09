package com.model;

import java.io.Serializable;

public class Json implements Serializable {
	private boolean success=false;//是否成功
	private String msg="";//提示信息
	private Object obj=null;//其他信息
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	

}
