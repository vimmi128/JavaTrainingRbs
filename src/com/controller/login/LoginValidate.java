package com.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import com.model.beans.*;
import com.model.login.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginValidate
 */
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		User newUser = new User();
		newUser.setUser(request.getParameter("username"));
		newUser.setPassword(request.getParameter("password"));
		LoginCheck bl = new LoginCheck();
		
		if(bl.checkLogin(newUser)) {
			
			HttpSession ses =  request.getSession();
			ses.setAttribute("user", newUser);
			response.sendRedirect("./Home.jsp");
		}
		else
		{
			System.out.println("login failed");
			response.sendRedirect("./LoginFailed.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
