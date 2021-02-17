package com.ritrageproductions.main.models;

import org.springframework.data.annotation.Id;

public class Memes {
	
	@Id
	private long id;
	private String name;
	private String url;
	private String caption;
	public Memes() {
		super();
	}
	public Memes(long id, String name, String url, String caption) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.caption = caption;
	}
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
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
