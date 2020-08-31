package comdxc.web.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import comdxc.web.beans.Student_exam;
import comdxc.web.beans.Student_subjects;

public class Student_subjectsJdbcDAO extends JdbcDAO {

	public Student_subjectsJdbcDAO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int save(Student_subjects ss) throws ClassNotFoundException {
		
		
		String sql = "INSERT INTO student_subjects VALUES(?,?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ss.getSid());
		pstmt.setInt(2, ss.getEid());
		pstmt.setInt(3, ss.getSub1());
		pstmt.setInt(4, ss.getSub2());
		pstmt.setInt(5, ss.getSub3());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int edit(Student_subjects ss) throws ClassNotFoundException {
		
		
		String sql = "update student_subjects set eid=?, sub1=?, sub2=?, sub3=? where sid=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, ss.getEid());
		pstmt.setInt(2, ss.getSub1());
		pstmt.setInt(3, ss.getSub2());
		pstmt.setInt(4, ss.getSub3());
		pstmt.setInt(5, ss.getSid());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public int delete(Student_subjects ss) throws ClassNotFoundException {
		
		String sql = "delete from student_subjects where sid=?";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, ss.getSid());
		
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
	}

	public Student_subjects find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Student_subjects> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
