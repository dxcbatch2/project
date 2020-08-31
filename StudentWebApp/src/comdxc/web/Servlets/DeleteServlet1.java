package comdxc.web.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comdxc.web.DAO.Student_examJdbcDAO;
import comdxc.web.beans.Student_exam;

/**
 * Servlet implementation class DeleteServlet1
 */
@WebServlet("/DeleteServlet1")
public class DeleteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student_examJdbcDAO examdao;
	public void init()
	{
		try {
			examdao=new Student_examJdbcDAO();
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
			Student_exam e=new Student_exam();
			try {
				e.setId(id);
				examdao.delete(e);
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			response.sendRedirect("scernario1.jsp");
		}	
	}
}