package com.dxc.web.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "registeration")
public class UserRegister 
{
	@Id
	@Column(name = "first_name", nullable = false, length = 100)
	private String first_name;
	@Column(name = "last_name", nullable = false, length = 100)
	private String last_name;
	@Column(name = "user_name", nullable = false, length = 100)
	private String username;
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	public UserRegister()
	{
		super();
	}
	public UserRegister(String first_name, String last_name, String username, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserRegister [first_name=" + first_name + ", last_name=" + last_name + ", username=" + username
				+ ", password=" + password + "]";
	}
	
}