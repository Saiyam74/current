package com.ritrageproductions.main.dtos;

public class MemeDTO {
	
	private String name;
	private String url;
	private String caption;
	public MemeDTO() {
		super();
	}
	public MemeDTO(String name, String url, String caption) {
		super();
		this.name = name;
		this.url = url;
		this.caption = caption;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	

}
