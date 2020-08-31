package comdxc.web.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comdxc.web.DAO.UserDAO;
import comdxc.web.DAO.UserRegisterDAO;
import comdxc.web.beans.User;
import comdxc.web.beans.UserRegister;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userdao;
	public void init()
	{
		try {
			userdao=new UserDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.isEmpty()||password.isEmpty())
		{
			RequestDispatcher rd=request.getRequestDispatcher("login2.jsp");
			rd.include(request, response);
		}
		else
		{
			User ur= new User();
			ur.setUsername(username);
			ur.setPassword(password);
			try {
			userdao.UserRetr(ur);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			response.sendRedirect("Login3.jsp");
		}
		
	}

}
