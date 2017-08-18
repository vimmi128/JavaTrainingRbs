package com.controller.displayAll;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.bl.*;
import com.model.beans.*;
import com.model.beans.User;
import com.model.login.LoginCheck;

/**
 * Servlet implementation class DisplayAll
 */
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession nsession = request.getSession(false);
		if(nsession!=null) {
			
			BusinessLogic bLogic=new BusinessLogic();
			ArrayList<Employee> listOfEmployees= bLogic.listAllEmployees();
			nsession.setAttribute("list", listOfEmployees);
			response.sendRedirect("./DisplayAllEmployees.jsp");
		}
		else
		  System.out.println("Session is not active");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
