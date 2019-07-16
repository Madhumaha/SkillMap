package com.niit.models;

import java.util.Date;

public class UserDetail {
	String emailid;  
	String name; 
	String address;  
	String phoneno;  
	@Override
	public String toString() {
		return "UserDetail [emailid=" + emailid + ", name=" + name + ", address=" + address + ", phoneno=" + phoneno
				+ ", password=" + password + ", registeredon=" + registeredon + ", compid=" + compid + ", role=" + role
				+ "]";
	}
	String password; 
	Date registeredon; 
	int compid; 
	String role;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisteredon() {
		return registeredon;
	}
	public void setRegisteredon(Date registeredon) {
		this.registeredon = registeredon;
	}
	public int getCompid() {
		return compid;
	}
	public void setCompid(int compid) {
		this.compid = compid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
