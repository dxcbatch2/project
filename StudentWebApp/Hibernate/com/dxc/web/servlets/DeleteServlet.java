package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.hibdaoimp.StudentJDBCDAO;


/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentJDBCDAO studentdao;
	public void init()
	{
		try {
			studentdao=new StudentJDBCDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
			RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
			rd.include(request, response);
		}
		
		else
		{
			
			try {
				studentdao.delete(id);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("scernario.jsp");
		}
	}

}
