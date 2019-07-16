package com.niit.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlServerDbConfig implements DbConnectionProvider {
	private static Connection con=null;  
	
	static{  
		try{  
		Class.forName(DRIVER);  
		con=DriverManager.getConnection(CONNECTION_URL);  
		}catch(Exception e){}  
		}  
		  
	 
	public static Connection connectDb()
	{
		return con;
	}
	public static void main(String[] args) {
		
		SqlServerDbConfig ss=new SqlServerDbConfig();
		Connection con=connectDb();
		if(con!=null)
		System.out.println(true);
		else
			System.out.println(false);
	}

}
