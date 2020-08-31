package comdxc.web.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comdxc.web.DAO.Student_subjectsJdbcDAO;
import comdxc.web.beans.Student_subjects;

/**
 * Servlet implementation class DeleteServlet2
 */
@WebServlet("/DeleteServlet2")
public class DeleteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student_subjectsJdbcDAO subjectdao;
    public void init() {
    	try {
    		subjectdao=new Student_subjectsJdbcDAO();
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
			Student_subjects s=new Student_subjects();
			
			try {
				s.setSid(sid);
				subjectdao.delete(s);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("Scernario2.jsp");
		}
		
	}

}
