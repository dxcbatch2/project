package com.dxc.web.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_exam")
public class Student_exam 
{
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "exam_name", nullable = false, length = 100)
	String exam_name;
	public Student_exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student_exam(int id, String exam_name) {
		super();
		this.id = id;
		this.exam_name = exam_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	@Override
	public String toString() {
		return "Student_exam [id=" + id + ", exam_name=" + exam_name + "]";
	}
	
}
