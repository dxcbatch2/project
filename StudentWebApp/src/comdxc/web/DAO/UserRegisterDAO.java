package comdxc.web.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import comdxc.web.beans.UserRegister;

public class UserRegisterDAO extends JdbcDAO
{
	public UserRegisterDAO() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public int UserRetr(UserRegister ur) throws ClassNotFoundException {
		
		
		String sql = "INSERT INTO userreg VALUES(?,?,?,?)";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","root");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ur.getFirst_name());
		pstmt.setString(2, ur.getLast_name());
		pstmt.setString(3, ur.getUsername());
		pstmt.setString(4, ur.getPassword());
		System.out.println(pstmt);
		result = pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return result;
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
