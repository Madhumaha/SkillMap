package com.niit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.niit.config.SqlServerDbConfig;
import com.niit.models.UserDetail;

public class UserDaoImpl implements UserDao{
	@Override
	public UserDetail register(UserDetail u) {
		System.out.println(u);
		try {
			Connection con=SqlServerDbConfig.connectDb();
			if(con!=null)
			{
			PreparedStatement pst=con.prepareStatement("insert into userdetail(emailid, name,address,phoneno,password,compid,role) values(?,?,?,?,?,?,?)");
			pst.setString(1, u.getEmailid());
			pst.setString(2,u.getName());
			pst.setString(3, u.getAddress());
			pst.setString(4, u.getPhoneno());
			pst.setString(5, u.getPassword());
			if(u.getCompid()!=0)
			pst.setInt(6,u.getCompid());
			else
				pst.setString(6, null);
			pst.setString(7,u.getRole());
			int i=pst.executeUpdate();
			if(i!=0)
			{
				System.out.println("registered");
				return u;
			}
			}
			else
				System.out.println("Registration error");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	} 
	
	
	
	public  UserDetail validate(String uname,String pwd)
	{  
		UserDetail validUser=new UserDetail();
		try
		{
			Connection con=SqlServerDbConfig.connectDb();
			PreparedStatement pst=con.prepareStatement("select * from userdetail where emailid=? and password=?");
			pst.setString(1,uname);
			pst.setString(2, pwd);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				validUser.setEmailid(rs.getString("emailid"));
				validUser.setName(rs.getString("name"));
				validUser.setRole(rs.getString("role"));
				validUser.setPhoneno(rs.getString("phoneno"));
				validUser.setAddress(rs.getString("address"));
				validUser.setRegisteredon(rs.getDate("registeredon"));
			}
			System.out.println(validUser);
			return validUser;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}



	@Override
	public UserDetail getUser(String email) {
		UserDetail user=new UserDetail();
		try
		{
			Connection con=SqlServerDbConfig.connectDb();
			PreparedStatement pst=con.prepareStatement("select * from userdetail where emailid=?");
			pst.setString(1,email);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				user.setEmailid(rs.getString("emailid"));
				user.setCompid(rs.getInt("compid"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setAddress(rs.getString("address"));
				user.setRegisteredon(rs.getDate("registeredon"));
			}
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
}
