package com.dxc.web.hibdaoimp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.dxc.web.beans.Student_exam_subjects;
import com.dxc.web.dao.ConnectionJDBC;
import com.dxc.web.dao.StudentDAO;
import com.dxc.web.utils.HibernateUtils;

public class Student_exam_subjectsJDBCDAO extends ConnectionJDBC implements StudentDAO<Student_exam_subjects>
{

	public Student_exam_subjectsJDBCDAO()
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	//Configuration configuration=new Configuration().configure();
	//ServiceRegistry serviceRegistry=new ServiceRegistryBuilder()
	//											.applySettings(configuration.getProperties())
	//											.buildServiceRegistry();
	//SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	
	//Session session=sessionFactory.openSession();
	//Transaction transaction=session.beginTransaction();
	@Override
	public Student_exam_subjects save(Student_exam_subjects e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO student_subjects VALUES(?,?,?,?,?)");
		pstmt.setInt(1, e.getSid());
		pstmt.setInt(2, e.getEid());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		
		session.save(e);
		session.getTransaction().commit();
        session.close();
        System.out.println(e.toString());
		return e;
	}
	

	@Override
	public Student_exam_subjects edit(Student_exam_subjects e) throws Exception {
		SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
		PreparedStatement pstmt = con.prepareStatement("UPDATE student_subjects SET eid=?,sub1=?,sub2=?,sub3=? WHERE sid = ?");
		pstmt.setInt(1, e.getSid());
		pstmt.setInt(2, e.getEid());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		
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
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM student_subjects WHERE sid = ?");
		pstmt.setInt(1, id);
		session.delete(id);
		session.getTransaction().commit();
        session.close();
		return id;
	}

	@Override
	public Student_exam_subjects find(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student_exam_subjects> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
