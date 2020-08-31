package com.dxc.web.beans;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_exam_subjects")
public class Student_exam_subjects implements Serializable
{
	@Id
	@Column(name = "sid")
	int sid;
	@Id
	@Column(name = "eid")
	int eid;
	@Column(name = "sub1")
	int sub1;
	@Column(name = "sub2")
	int sub2;
	@Column(name = "sub3")
	int sub3;
	public Student_exam_subjects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student_exam_subjects(int sid, int eid, int sub1, int sub2, int sub3) {
		super();
		this.sid = sid;
		this.eid = eid;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	@Override
	public String toString() {
		return "Student_exam_subjects [sid=" + sid + ", eid=" + eid + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3="
				+ sub3 + "]";
	}
	
}
