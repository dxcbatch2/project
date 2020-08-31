package comdxc.web.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comdxc.web.DAO.UserRegisterDAO;
import comdxc.web.beans.UserRegister;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRegisterDAO userdao;
	public void init()
	{
		try {
			userdao=new UserRegisterDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(first_name.isEmpty()||last_name.isEmpty()||username.isEmpty()||password.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else
		{
			UserRegister ur= new UserRegister();
			ur.setFirst_name(first_name);
			ur.setLast_name(last_name);
			ur.setUsername(username);
			ur.setPassword(password);
			try {
			userdao.UserRetr(ur);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("login1.jsp");
		}
		
		
	}

}
