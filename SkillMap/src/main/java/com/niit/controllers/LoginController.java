package com.niit.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.config.SqlServerDbConfig;
import com.niit.dao.JobAppDao;
import com.niit.dao.JobAppDaoImpl;
import com.niit.dao.JobDao;
import com.niit.dao.JobDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.models.Job;
import com.niit.models.JobApplication;
import com.niit.models.UserDetail;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao=new UserDaoImpl();
	JobDao jobDao=new JobDaoImpl();
	JobAppDao jobappDao=new JobAppDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String psw=request.getParameter("psw");
		UserDetail validUser=userDao.validate(uname, psw);
		HttpSession session=request.getSession();
		session.setAttribute("email",validUser.getEmailid());
		session.setAttribute("loggedInUser",validUser.getName());
		session.setAttribute("userRole",validUser.getRole());
			if(session.getAttribute("userRole").equals("Employer"))
			{
			//response.getWriter().println("<h1>success</h1>  ");
			    request.getRequestDispatcher("/WEB-INF/views/employerHomepage.jsp").forward(request, response);
			}
			else if(session.getAttribute("userRole").equals("Employee"))
			{
				List<Job> jobList=jobDao.viewJobs();
				request.setAttribute("alljobs", jobList);
				request.getRequestDispatcher("/WEB-INF/views/employeeHomepage.jsp").forward(request, response);
			}
			else
			{
//				List<JobApplication> newapps=jobappDao.alljobapps('N');
//				request.setAttribute("newapps",newapps);
			    request.getServletContext().getRequestDispatcher("/hr").forward(request, response);
		
			}
		
	}

}
