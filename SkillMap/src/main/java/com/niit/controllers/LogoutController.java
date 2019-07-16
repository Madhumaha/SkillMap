package com.niit.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("loggedInUser");
		session.removeAttribute("email");
		session.removeAttribute("userRole");
		session.invalidate();
		response.getWriter().print("<h1>Logged out</h1>");
		request.getRequestDispatcher("/login").include(request, response);
	}

	

}
