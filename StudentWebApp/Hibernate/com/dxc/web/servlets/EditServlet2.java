package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.beans.Student_exam_subjects;
import com.dxc.web.hibdaoimp.Student_exam_subjectsJDBCDAO;


/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student_exam_subjectsJDBCDAO subjectdao;
    public void init() {
    	try {
    		subjectdao=new Student_exam_subjectsJDBCDAO();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid=Integer.parseInt(request.getParameter("sid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		int sub1=Integer.parseInt(request.getParameter("sub1"));
		int sub2=Integer.parseInt(request.getParameter("sub2"));
		int sub3=Integer.parseInt(request.getParameter("sub3"));
		if(sid==0||eid==0||sub1==0||sub2==0||sub3==0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("subjects.jsp");
			rd.include(request, response);
		}
		else
		{
			Student_exam_subjects s=new Student_exam_subjects();
			s.setSid(sid);
			s.setEid(eid);
			s.setSub1(sub1);
			s.setSub2(sub2);
			s.setSub3(sub3);
			try {
				subjectdao.edit(s);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("Scernario2.jsp");
		}
		
	}

}