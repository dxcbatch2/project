package com.dxc.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.hibdaoimp.StudentJDBCDAO;

import com.dxc.web.beans.Student;



/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
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
    public SaveServlet() {
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
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		if((id==0)||name.isEmpty()||email.isEmpty()||phoneno.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
			rd.include(request, response);
		}
		
		else
		{
			Student s=new Student();
			s.setId(id);
			s.setName(name);
			s.setEmail(email);
			s.setPhoneno(phoneno);
			try {
				
				studentdao.save(s);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("scernario.jsp");
		}
	}
}
