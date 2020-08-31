package com.dxc.web.servlets;

import java.io.IOException;
import java.sql.SQLException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.web.beans.Student;
import com.dxc.web.hibdaoimp.StudentJDBCDAO;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
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
    public List() {
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
		String action = request.getServletPath();
		try {
            switch (action) {
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
				try {
					deleteUser(request, response);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                    break;
                case "/update":
				try {
					updateUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                default:
				try {
					liststudent(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void liststudent(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	java.util.List<Student> student = studentdao.findAll();
        request.setAttribute("liststudent", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));        
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneno = request.getParameter("phoneno");
        Student newUser = new Student(id, name, email, phoneno);
        studentdao.save(newUser);
        response.sendRedirect("list");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneno = request.getParameter("phoneno");

        Student s = new Student(id, name, email, phoneno);
        studentdao.edit(s);
        response.sendRedirect("list");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        studentdao.delete(id);
        response.sendRedirect("list");

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    	        Student existingstudent = studentdao.selectUser(id);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
    	        request.setAttribute("student", existingstudent);
    	        dispatcher.forward(request, response);

    	    }
    
}

