package com.dxc.web.hibdaoimp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.web.beans.User;
import com.dxc.web.dao.ConnectionJDBC;
import com.dxc.web.dao.StudentDAO;
import com.dxc.web.utils.HibernateUtils;

public class UserJDBCDAO extends ConnectionJDBC implements StudentDAO<User>
{

	public UserJDBCDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User save(User e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        e.getUsername();
        e.getPassword();
		
		session.save(e);
		session.getTransaction().commit();
        session.close();
        System.out.println(e.toString());
		return e;
	}

	@Override
	public User edit(User e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
