//package com.niit.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DbConfig {
//	public boolean connectDb()
//	{
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/skills","root","password@123");
//		if(con!=null)
//			return true;
//		
//			
//	} catch (Exception e) {
//		System.out.println(e);
//	}
//	return false;
//	}
//	
//	public static void main(String[] a)
//	{
//		DbConfig dc=new DbConfig();
//		System.out.println(dc.connectDb());
//	}
//}
