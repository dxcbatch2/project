package com.dxc.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student 
{
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "name", nullable = false, length = 100)
	String name;
	@Column(name = "email", nullable = false, length = 100)
	String email;
	@Column(name = "phoneno", nullable = false, length = 10)
	String phoneno;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String email, String phoneno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno + "]";
	}
	
}
