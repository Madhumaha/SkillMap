package com.niit.config;

public interface DbConnectionProvider {
	String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	String CONNECTION_URL="jdbc:sqlserver://localhost\\sqlexpress;databaseName=SkillMap;integratedSecurity=true";  
	String USERNAME="";  
	String PASSWORD=""; 
}
