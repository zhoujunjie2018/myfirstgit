package com.model;

public class Resource {
	
	private Integer id;
	private String url;
	private String name;
	private Integer checked;
	private String icon;
	private Integer parent_id;
	
	public Resource() {
		super();
	}

	public Resource(Integer id, String url, String name, Integer checked,
			String icon, Integer parent_id) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.checked = checked;
		this.icon = icon;
		this.parent_id = parent_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	
	
	

}
