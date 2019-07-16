package com.niit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.niit.config.SqlServerDbConfig;
import com.niit.models.Job;
import com.niit.models.JobApplication;

public class JobAppDaoImpl  implements JobAppDao{

	@Override
	public List<JobApplication> jobapplist(int jobid) {
		List<JobApplication> jobappList=new ArrayList<JobApplication>();
		JobApplication ja=new JobApplication();
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("select * from jobapp where jobid=? and appstatus=?");
			pst.setInt(1, jobid);
			pst.setString(2, String.valueOf('A'));
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ja.setJobappid(rs.getInt("jobappid"));
				ja.setJobid(rs.getInt("jobid"));
				ja.setEmailid(rs.getString("emailid"));
				ja.setAppliedon(rs.getDate("appliedon"));
				ja.setAppstatus(rs.getString("appstatus").charAt(0));
				ja.setRejectionreason(rs.getString("rejectionreason"));
				jobappList.add(ja);
			}
			return jobappList;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public JobApplication applyforjob(JobApplication ja) {
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("insert into jobapp(jobid,emailid,appstatus) values(?,?,?)");
			pst.setInt(1, ja.getJobid());
			pst.setString(2, ja.getEmailid());
			pst.setString(3, String.valueOf(ja.getAppstatus()));
			int i=pst.executeUpdate();
			if(i!=0)
			{
				System.out.println("Applied for the job");
				return ja;
			}
			}
			else
				System.out.println("Application error");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<JobApplication> alljobapps(char appstatus) {
		List<JobApplication> jobappList=new ArrayList<JobApplication>();
		
		JobApplication ja=new JobApplication();
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("select * from jobapp where appstatus=?");
			pst.setString(1, String.valueOf(appstatus));
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ja.setJobappid(rs.getInt("jobappid"));
				ja.setJobid(rs.getInt("jobid"));
				ja.setEmailid(rs.getString("emailid"));
				ja.setAppliedon(rs.getDate("appliedon"));
				ja.setAppstatus(rs.getString("appstatus").charAt(0));
				ja.setRejectionreason(rs.getString("rejectionreason"));
				
				jobappList.add(ja);
			}
			return jobappList;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public JobApplication getjobapp(int jobappid) {
		JobApplication ja=new JobApplication();
	
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("select * from jobapp where jobappid=?");
			pst.setInt(1, jobappid);
			
			ResultSet rs=pst.executeQuery();
			rs.next();
			ja.setJobappid(rs.getInt("jobappid"));
			ja.setJobid(rs.getInt("jobid"));
			ja.setEmailid(rs.getString("emailid"));
			ja.setAppliedon(rs.getDate("appliedon"));
			ja.setAppstatus(rs.getString("appstatus").charAt(0));
			ja.setRejectionreason(rs.getString("rejectionreason"));
			return ja;
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public JobApplication updatejobapp(int jobappid,char appstatus,String reason) {
		
		try {
			Connection con=SqlServerDbConfig.connectDb();
			PreparedStatement pst=null;
			if(con!=null)
			{
				if(appstatus=='A')
				{
					pst=con.prepareStatement("update jobapp set appstatus=? where jobappid=?");
					pst.setString(1, String.valueOf(appstatus));
					pst.setInt(2, jobappid);
				}
				if(appstatus=='R')
				{
					pst=con.prepareStatement("update jobapp set appstatus=?,rejectionreason=?  where jobappid=?");
					pst.setString(1, String.valueOf(appstatus));
					pst.setString(2, reason);
					pst.setInt(3, jobappid);
				}
				int i=pst.executeUpdate();
				if(i!=0)
				{
					JobApplication ja=getjobapp(jobappid);
					return ja;
				}
				else
				return null;
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
