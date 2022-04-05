package com.springbootdemo.requesthandlingdemo.model;

public class User {
	private String email, password;
	private int phone;

	public User() {}
	
	public User(String email, String password, int phone) {
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
