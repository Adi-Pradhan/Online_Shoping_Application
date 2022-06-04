package com.zensar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private int userName;
	private String password;
	public int getAdminId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public int getUserName() {
		return userName;
	}
	public void setUserName(int userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "user [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerUser(int userId, int userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
}
