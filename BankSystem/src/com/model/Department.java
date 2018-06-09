package com.model;

public class Department {
	private Integer id;
	private String departName;
	
	
	
	
	
	public Department() {
		super();
	}
	
	
	
	
	public Department(Integer id) {
		super();
		this.id = id;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName + "]";
	}
	
	
	

}
