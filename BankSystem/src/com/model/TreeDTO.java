package com.model;

import java.util.HashMap;
import java.util.Map;

public class TreeDTO {
	
	private Integer id;
	private String text;
	private String iconCls;
	private Integer checked;
	private Integer parent_id;
	private String state;
	
	private Map<String ,Object> attributes=new HashMap<String, Object>();

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public TreeDTO() {
		super();
	}

	
	public TreeDTO(Integer id, String text, String iconCls, Integer checked,
			Integer parent_id, String state, Map<String, Object> attributes) {
		super();
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.checked = checked;
		this.parent_id = parent_id;
		this.state = state;
		this.attributes = attributes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	
	
	
	

}
