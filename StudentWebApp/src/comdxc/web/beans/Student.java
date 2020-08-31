package comdxc.web.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Student 
{
	int id;
	String name;
	String email;
	String phoneno;
	
	public Student() {
		super();
	}
	public Student(int id, String name, String email, String phoneno) throws ParseException {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.phoneno=phoneno;
		
		
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
	public String getPhone() {
		return phoneno;
	}
	public void setPhone(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
	@Override
	public String toString() {

		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno +  "]";
	}
	public String toCSV() {
		
		return id+","+name+","+email+","+phoneno;
	}
	public static Student parseStudent(String csvStudent) throws ParseException {
		
		String[] values = csvStudent.split(",");
		int id = Integer.parseInt(values[0].trim());
		String name = values[1].trim();
		
		String email = values[2].trim();
		String mobile = values[3].trim();

		
		Student student = new Student(id, name, email, mobile);
		
		return student;
	}
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.getId();
	}
	
	
}
