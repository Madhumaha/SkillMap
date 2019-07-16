package com.niit.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.config.SqlServerDbConfig;
import com.niit.dao.CompanyDao;
import com.niit.dao.CompanyDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.models.Company;
import com.niit.models.UserDetail;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDao userDao=new UserDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyDao companyDao=new CompanyDaoImpl();
		List<Company> complist=companyDao.listallcompanies();
		request.setAttribute("companylist",complist);
		request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserDetail ud=new UserDetail();
		
		
		ud.setEmailid(request.getParameter("email"));
		ud.setName(request.getParameter("name"));
		ud.setAddress(request.getParameter("address"));
		ud.setPhoneno(request.getParameter("phno"));
		ud.setPassword(request.getParameter("psw"));
		if(request.getParameter("companyid")!=null)
		ud.setCompid(Integer.parseInt(request.getParameter("companyid")));
		ud.setRole(request.getParameter("role"));
		
		userDao.register(ud);
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	
	}

}
