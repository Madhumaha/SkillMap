package com.niit.dao;

import java.util.HashMap;
import java.util.List;

import com.niit.models.JobApplication;

public interface JobAppDao {
public List<JobApplication> jobapplist(int jobid);
public JobApplication applyforjob(JobApplication ja);
public List<JobApplication> alljobapps(char appstatus);
public JobApplication getjobapp(int jobappid);
public JobApplication updatejobapp(int jobappid,char appstatus,String reason);
}
