package com.niit.models;

import java.util.Date;

public class Job {
int jobid;
int compid;
String jobtitle;
String qualification;
String experience;
String location;
String ctc;
Date postedon;
String lastdate;
String reqskills;


public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public int getCompid() {
	return compid;
}
public void setCompid(int compid) {
	this.compid = compid;
}
public String getJobtitle() {
	return jobtitle;
}
public void setJobtitle(String jobtitle) {
	this.jobtitle = jobtitle;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getExperience() {
	return experience;
}
public void setExperience(String experience) {
	this.experience = experience;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getCtc() {
	return ctc;
}
public void setCtc(String ctc) {
	this.ctc = ctc;
}
public Date getPostedon() {
	return postedon;
}
public void setPostedon(Date postedon) {
	this.postedon = postedon;
}
public String getLastdate() {
	return lastdate;
}
public void setLastdate(String lastdate) {
	this.lastdate = lastdate;
}
public String getReqskills() {
	return reqskills;
}
public void setReqskills(String reqskills) {
	this.reqskills = reqskills;
}


}
