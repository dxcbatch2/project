package com.dxc.web.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.dxc.web.utils.ConnectionManager;

public class ConnectionJDBC 
{
	protected Connection con = null;
	public ConnectionJDBC() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
	}
	
	public void save() throws SQLException {
		con.commit();
		con.close();
	}
	
	public void undo() throws SQLException {
		con.rollback();
		con.close();
	}
}
