package com.niit.dao;

import java.util.List;

import com.niit.models.Job;

public interface JobDao {
public void addJob(Job j);
public List<Job> viewJobs();
public List<Job> listCompanyJobs(int compid);
public Job getJob(int jobid);
public void deleteJob(Job j);
public Job updateJob(Job j);
}
