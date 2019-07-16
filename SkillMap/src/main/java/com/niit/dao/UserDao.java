package com.niit.dao;

import com.niit.models.UserDetail;

public interface UserDao {
	public UserDetail register(UserDetail u);
	public UserDetail validate(String uname,String pwd);
	public UserDetail getUser(String email);
}
