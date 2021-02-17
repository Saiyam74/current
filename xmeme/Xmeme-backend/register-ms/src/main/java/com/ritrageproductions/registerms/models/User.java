package com.ritrageproductions.registerms.models;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private String username;
	private String fullname;
	private int age;
	private String email;
	
	public User() {
		super();
	}
	public User(String username, String fullname, int age, String email) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.age = age;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
