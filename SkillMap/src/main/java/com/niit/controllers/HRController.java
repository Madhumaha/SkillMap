package com.niit.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobAppDao;
import com.niit.dao.JobAppDaoImpl;
import com.niit.dao.JobDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.models.JobApplication;
import com.niit.models.UserDetail;

public class HRController extends HttpServlet {
	JobAppDao jobappDao=new JobAppDaoImpl();
	UserDao userDao=new UserDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<JobApplication> jobapps=jobappDao.alljobapps('N');
		List<UserDetail> ulist=new ArrayList<>();
		request.setAttribute("newjobapps",jobapps);
		for(JobApplication ja:jobapps)
		{
			String emailid=ja.getEmailid();
			ulist.add(userDao.getUser(emailid));
		}
		request.setAttribute("userList",ulist);
		if(request.getParameter("btn")!=null)
		if(request.getParameter("btn").equals("approve"))
		{
			int jobappid=Integer.parseInt(request.getParameter("jobappid"));
			jobappDao.updatejobapp(jobappid, 'A',null);
		}
		if(request.getParameter("btn")!=null)
		if(request.getParameter("btn").equals("reject"))
		{
			int jobappid=Integer.parseInt(request.getParameter("jobappid"));
			String email=request.getParameter("email");
			request.setAttribute("jobapp",jobappDao.getjobapp(jobappid));
			request.setAttribute("applicant",userDao.getUser(email));
			request.getRequestDispatcher("/WEB-INF/views/viewJobapp.jsp").forward(request, response);
		}
		if(request.getParameter("rejectreasonbtn")!=null)
		{
			String reason=request.getParameter("reason");
			int jobappid=Integer.parseInt(request.getParameter("jobappid"));
			JobApplication ja=jobappDao.updatejobapp(jobappid, 'R',reason);
			request.getRequestDispatcher("/WEB-INF/views/HR.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("/WEB-INF/views/HR.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
