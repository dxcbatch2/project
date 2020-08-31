package com.dxc.web.hibdaoimp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.web.beans.Student;

import com.dxc.web.dao.ConnectionJDBC;
import com.dxc.web.dao.StudentDAO;
import com.dxc.web.utils.HibernateUtils;


public class StudentJDBCDAO extends ConnectionJDBC implements StudentDAO<Student>
{

	public StudentJDBCDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	//Configuration configuration=new Configuration().configure();
	//ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
	//											.applySettings(configuration.getProperties())
	//											.buildServiceRegistry();
	//SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	//
	//Session session=sessionFactory.openSession();
	//Transaction transaction=session.beginTransaction();
	
	@Override
	public Student save(Student e) throws SQLException  {
		
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        e.getId();
        e.getName();
        e.getEmail();
        e.getPhoneno();
		
		session.save(e);
		session.getTransaction().commit();
        session.close();
        System.out.println(e.toString());
		return e;
		
		
	}

	@Override
	public Student edit(Student e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("UPDATE student SET name=?, email=?, phoneno=? WHERE id = ?");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		
		pstmt.setString(3, e.getEmail());
		pstmt.setString(4, e.getPhoneno());
		
		session.update(e);
		session.getTransaction().commit();
        session.close();
        System.out.println(e.toString());
		return e;
	}

	@Override
	public int delete(int id) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM student WHERE id = ?");
		pstmt.setInt(1, id);
		session.delete(id);
		session.getTransaction().commit();
        session.close();
		return id;
		
	}

	@Override
	public Student find(int id) throws Exception {
		Student student = null;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phoneno = rs.getString(4);
				student = new Student(id, name, email, phoneno);
			}
		}
		finally {
			con.close();
		}
		
		return student;
	}

	@Override
	public List<Student> findAll() throws Exception {
		 List < Student > student = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try {

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement("select * from student"); 
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String phoneno = rs.getString("phoneno");
	                student.add(new Student(id, name, email, phoneno));
	            }
	        } 
	         catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	   }

	public Student selectUser(int id) {
		 Student student = null;
	        // Step 1: Establishing a Connection
	        try {
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement("select from student where id=?"); 
	            preparedStatement.setInt(1, id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                String phoneno = rs.getString("phoneno");
	                student = new Student(id, name, email, phoneno);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	}
}