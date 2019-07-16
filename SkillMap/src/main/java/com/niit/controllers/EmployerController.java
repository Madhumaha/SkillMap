package com.niit.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.dao.JobDao;
import com.niit.dao.JobDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.models.Job;
import com.niit.models.UserDetail;

public class EmployerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JobDao jobDao=new JobDaoImpl();
	UserDao userDao=new UserDaoImpl();
	
	Job j=new Job();
	UserDetail u=new UserDetail();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getParameter("listbtn")!=null)
		{
		u=userDao.getUser((String)request.getSession().getAttribute("email"));
    	List<Job> jobList=jobDao.listCompanyJobs(u.getCompid());
    	request.setAttribute("companyJobs",jobList);
    	request.getRequestDispatcher("WEB-INF/views/employerHomepage.jsp").forward(request, response);
		}
	else
		request.getRequestDispatcher("/login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        if (request.getParameter("addjob") != null) {
        	//jobid;
        	//int compid;
        	u=userDao.getUser((String)request.getSession().getAttribute("email"));
        	j.setCompid(u.getCompid());
        	j.setJobtitle(request.getParameter("jobtitle"));
        	j.setQualification(request.getParameter("qualification"));
        	j.setExperience(request.getParameter("experience"));
        	j.setLocation(request.getParameter("location"));
        	j.setCtc(request.getParameter("ctc"));
        	j.setPostedon(new Date());//Date postedon;
        	j.setLastdate(request.getParameter("lastdate"));
        	j.setReqskills(request.getParameter("reqskills"));
           jobDao.addJob(j);
        } 
//        else if (request.getParameter("button2") != null) {
//            myClass.method2();
//        } else if (request.getParameter("button3") != null) {
//            myClass.method3();
//        } else {
//            // ???
//        }
	}

}
