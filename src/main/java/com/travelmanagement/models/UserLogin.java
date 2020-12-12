package com.travelmanagement.models;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class UserLogin {

	@Id
	private String name;
	private String pass;
	public UserLogin() {
		super();
	}
	public UserLogin(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
