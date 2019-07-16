package com.niit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.niit.config.SqlServerDbConfig;
import com.niit.models.Company;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	public List<Company> listallcompanies() {
		List<Company> complist=new ArrayList<>();
		try
		{
			Connection con=SqlServerDbConfig.connectDb();
		PreparedStatement pst=con.prepareStatement("select * from company");
		
	ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			
		Company comp=new Company();
			comp.setCompid(rs.getInt("compid"));
			comp.setCompname(rs.getString("compname"));
			comp.setCompcontactno(rs.getString("compcontactno"));
			comp.setCompemailid(rs.getString("compemailid"));
			comp.setCompaddress(rs.getString("compaddress"));
			
			
			complist.add(comp);
		}
		
		}
		catch(Exception e)
		{
			
		}
		return complist;
	}
}
