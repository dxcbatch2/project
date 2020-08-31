package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.hibdaoimp.Student_examJDBCDAO;

/**
 * Servlet implementation class DeleteServlet1
 */
@WebServlet("/DeleteServlet1")
public class DeleteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student_examJDBCDAO examdao;
	public void init()
	{
		try {
			examdao=new Student_examJDBCDAO();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		if((id==0))
		{
			RequestDispatcher rd=request.getRequestDispatcher("exam.jsp");
			rd.include(request, response);
		}
		
		else
		{
			try {
				examdao.delete(id);
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			response.sendRedirect("scernario1.jsp");
		}	
	}
}