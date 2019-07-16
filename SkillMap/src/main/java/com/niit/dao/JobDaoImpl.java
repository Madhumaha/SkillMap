package com.niit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.niit.config.SqlServerDbConfig;
import com.niit.models.Job;
import com.niit.models.JobApplication;

public class JobDaoImpl implements JobDao{
Job j=new Job();
	@Override
	public void addJob(Job j) {
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("insert into job(compid,jobtitle,qualification,experience,location,ctc,lastdate,reqskills) values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, j.getCompid());
			pst.setString(2,j.getJobtitle());
			pst.setString(3, j.getQualification());
			pst.setString(4, j.getExperience());
			pst.setString(5, j.getLocation());
			pst.setString(6,j.getCtc());
			//pst.setString(7,j.getPostedon());
			pst.setString(7, j.getLastdate());
			pst.setString(8, j.getReqskills());
			int i=pst.executeUpdate();
			if(i!=0)
			{
				System.out.println("Posted new job");
				
			}
			else
				System.out.println("error in posting job");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Job> viewJobs() {
		List<Job> jobList=new ArrayList<Job>();
		Job j=new Job();
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("select * from job ");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				j.setJobid(rs.getInt("jobid"));
				
				j.setCompid(rs.getInt("compid"));
				j.setCtc(rs.getString("ctc"));
				j.setExperience(rs.getString("experience"));
				j.setJobtitle(rs.getString("jobtitle"));
				j.setLastdate(rs.getString("lastdate"));
				j.setLocation(rs.getString("location"));
				j.setPostedon(rs.getDate("postedon"));
				j.setQualification(rs.getString("qualification"));
				j.setReqskills(rs.getString("reqskills"));
				jobList.add(j);
			}
			return jobList;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Job getJob(int jobid) {
		return null;
	}

	@Override
	public void deleteJob(Job j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Job updateJob(Job j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> listCompanyJobs(int compid) {
		List<Job> jobList=new ArrayList<Job>();
		try {
			Connection con=SqlServerDbConfig.connectDb();
			PreparedStatement pst=con.prepareStatement("select * from job where compid="+compid);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
			j.setJobid(rs.getInt("jobid"));
			j.setCompid(rs.getInt("compid"));
        	j.setJobtitle(rs.getString("jobtitle"));
        	j.setQualification(rs.getString("qualification"));
        	j.setExperience(rs.getString("experience"));
        	j.setLocation(rs.getString("location"));
        	j.setCtc(rs.getString("ctc"));
        	j.setPostedon(rs.getDate("postedon"));
        	j.setLastdate(rs.getString("lastdate"));
        	j.setReqskills(rs.getString("reqskills"));
        	jobList.add(j);
			}
        	return jobList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	

}
