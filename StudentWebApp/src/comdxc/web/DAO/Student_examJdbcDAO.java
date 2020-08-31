package comdxc.web.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import comdxc.we.util.ConnectionManager;

import comdxc.web.beans.Student_exam;
import comdxc.web.beans.User;

public class Student_examJdbcDAO extends JdbcDAO  {

	public Student_examJdbcDAO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int save(Student_exam se) throws ClassNotFoundException {
		
		
		String sql = "INSERT INTO student_exam VALUES(?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, se.getId());
		pstmt.setString(2, se.getExam_name());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}
	

	public int Edit(Student_exam se) throws ClassNotFoundException {
		
		
		String sql = "update student_exam set exam_name=? where id=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, se.getExam_name());
		pstmt.setInt(2, se.getId());
		
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}
	public int delete(Student_exam se) throws ClassNotFoundException {
		
		String sql = "delete from student_exam where id=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, se.getId());
		
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public Student_exam find(int id) throws Exception {
		Student_exam student = null;
		
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student_exam WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String exam_name = rs.getString(2);
				
				
				student = new Student_exam(id, exam_name);
			}
		}
		finally {
			con.close();
		}
		
		return student;
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

}
