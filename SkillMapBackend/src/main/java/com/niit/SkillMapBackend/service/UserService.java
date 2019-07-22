package com.niit.SkillMapBackend.service;

import java.util.List;

import com.niit.SkillMapBackend.model.UserDetail;

public interface UserService {
	public boolean isEmailUnique(String email);
	public void registerCustomer(UserDetail u) ;
	UserDetail getUser(int eid);
	boolean updateUser(UserDetail u);
	boolean deleteUser(int eid);
	List<UserDetail> listUsers();
}
