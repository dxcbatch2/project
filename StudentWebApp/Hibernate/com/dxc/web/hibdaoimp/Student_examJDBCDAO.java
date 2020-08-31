package com.dxc.web.hibdaoimp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dxc.web.beans.Student_exam;
import com.dxc.web.dao.ConnectionJDBC;
import com.dxc.web.dao.StudentDAO;
import com.dxc.web.utils.HibernateUtils;

public class Student_examJDBCDAO extends ConnectionJDBC implements StudentDAO<Student_exam> 
{

	public Student_examJDBCDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	//Configuration configuration=new Configuration().configure();
	//ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
		//										.applySettings(configuration.getProperties())
			//									.buildServiceRegistry();
	//SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	
	//Session session=sessionFactory.openSession();
	//Transaction transaction=session.beginTransaction();

	@Override
	public Student_exam save(Student_exam e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO student_exam VALUES(?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getExam_name());
		
		session.save(e);
		session.getTransaction().commit();
        session.close();
        System.out.println(e.toString());
		return e;
	}

	@Override
	public Student_exam edit(Student_exam e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("UPDATE student_exam SET exam_name=? WHERE id = ?");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getExam_name());
		
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
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM student_exam WHERE id = ?");
		pstmt.setInt(1, id);
		session.delete(id);
		session.getTransaction().commit();
        session.close();
		return id;
	}

	@Override
	public Student_exam find(int id) throws Exception {
		Student_exam student = null;
		
		try {
			
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

	@Override
	public List<Student_exam> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
