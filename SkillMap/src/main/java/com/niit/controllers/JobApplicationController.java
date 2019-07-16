package com.niit.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.niit.dao.JobAppDao;
import com.niit.dao.JobAppDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.models.JobApplication;
import com.niit.models.UserDetail;

public class JobApplicationController extends HttpServlet {
	JobAppDao jobappDAO=new JobAppDaoImpl();
	UserDao userDao=new UserDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobid=Integer.parseInt(request.getParameter("jobid"));
		List<JobApplication> jobappList=jobappDAO.jobapplist(jobid);
		List<UserDetail> ulist=new ArrayList<>();
		for(JobApplication ja:jobappList)
		{
			ulist.add(userDao.getUser(ja.getEmailid()));
		}
		request.setAttribute("jobappList",jobappList);
		request.setAttribute("userList",ulist);
		request.getRequestDispatcher("/WEB-INF/views/viewjobapps.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
JobApplication ja=new JobApplication();
HttpSession session=request.getSession();
		ja.setJobid(Integer.parseInt(request.getParameter("jobid")));
		ja.setEmailid((String)session.getAttribute("email"));
		ja.setAppstatus('N');
		jobappDAO.applyforjob(ja);
		List<JobApplication> jobappList=jobappDAO.jobapplist(Integer.parseInt(request.getParameter("jobid")));
		List<UserDetail> ulist=new ArrayList<>();
		for(JobApplication ja1:jobappList)
		{
			ulist.add(userDao.getUser(ja1.getEmailid()));
		}
		request.setAttribute("jobappList",jobappList);
		request.setAttribute("userList",ulist);
		request.getRequestDispatcher("/WEB-INF/views/viewjobapps.jsp").forward(request, response);
	}

}
