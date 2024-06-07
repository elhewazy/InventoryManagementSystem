package com.elhewazy.model;

public class User {

	private String email;
	private String password;
	private int id;

	public User(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return password;
	}

	public void setName(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
