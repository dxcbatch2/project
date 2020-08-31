package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.hibdaoimp.Student_exam_subjectsJDBCDAO;


/**
 * Servlet implementation class DeleteServlet2
 */
@WebServlet("/DeleteServlet2")
public class DeleteServlet2 extends HttpServlet {
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
    public DeleteServlet2() {
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
		
		if(sid==0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("subjects.jsp");
			rd.include(request, response);
		}
		else
		{
			try {
				subjectdao.delete(sid);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("Scernario2.jsp");
		}
		
	}

}
