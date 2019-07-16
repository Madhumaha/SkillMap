package com.niit.models;

import java.util.Date;

public class JobApplication {
int jobappid;
int jobid;
String emailid;
Date appliedon;
char appstatus;
String rejectionreason;


public int getJobappid() {
	return jobappid;
}
public void setJobappid(int jobappid) {
	this.jobappid = jobappid;
}
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public Date getAppliedon() {
	return appliedon;
}
public void setAppliedon(Date appliedon) {
	this.appliedon = appliedon;
}
public char getAppstatus() {
	return appstatus;
}
public void setAppstatus(char appstatus) {
	this.appstatus = appstatus;
}
public String getRejectionreason() {
	return rejectionreason;
}
public void setRejectionreason(String rejectionreason) {
	this.rejectionreason = rejectionreason;
}


}
