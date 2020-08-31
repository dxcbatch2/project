package comdxc.web.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import comdxc.we.util.ConnectionManager;

import comdxc.web.beans.Student;
import comdxc.web.beans.Student_subjects;

public class StudentJdbcDAO extends JdbcDAO 
{
	public StudentJdbcDAO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int save(Student s) throws ClassNotFoundException {
		
		
		String sql = "INSERT INTO student VALUES(?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, s.getId());
		pstmt.setString(2, s.getName());
		pstmt.setString(3, s.getEmail());
		pstmt.setString(4, s.getPhone());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int edit(Student s) throws ClassNotFoundException {
		
		
		String sql = "update student set name=?, email=?, mobileno=? where id=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, s.getName());
		pstmt.setString(2, s.getEmail());
		pstmt.setString(3, s.getPhone());
		pstmt.setInt(4, s.getId());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int delete(Student s) throws ClassNotFoundException {
		
		String sql = "delete from student where id=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, s.getId());
		
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int find1(Student s) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE id = ?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getEmail());
			pstmt.setString(4, s.getPhone());
			
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				printSQLException(e);
			}
			return result;
	}

	public List<Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> students = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				String email = rs.getString("email");
				String mobile = rs.getString("phoneno");
				Student student = new Student(id, name, email, mobile);
				students.add(student);
			}
		}
		finally {
			con.close();
		}
		
		
		return students;
	}
	public String csvAll() throws SQLException, ParseException {
		String fullcsv="";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM student");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			String email = rs.getString("email");
			String mobile = rs.getString("phoneno");
			
			
			Student student = new Student(id, name, email, mobile);
			fullcsv+=student.toCSV()+"\n";
		}
		
		
		return fullcsv;
	}
	private void printSQLException(SQLException ex) {
		for(Throwable e:ex)
		{
			if(e instanceof SQLException)
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: "+((SQLException) e).getSQLState());
				System.err.println("Error code: "+((SQLException) e).getErrorCode());
				System.err.println("Message: "+e.getMessage());
			}
		}
		
	}

	public int find(Student s) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM student WHERE id = ?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getEmail());
			pstmt.setString(4, s.getPhone());
			
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
			}
			catch(SQLException e)
			{
				printSQLException(e);
			}
			return result;
	}
}
