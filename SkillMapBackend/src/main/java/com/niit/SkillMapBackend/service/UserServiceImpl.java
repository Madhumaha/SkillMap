package com.niit.SkillMapBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SkillMapBackend.dao.UserDao;
import com.niit.SkillMapBackend.model.UserDetail;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDAO;
	@Override
	public boolean isEmailUnique(String email)
	{
		return userDAO.isEmailUnique(email);
	}
	
	@Override
	public void registerCustomer(UserDetail u) {
		userDAO.registerCustomer(u);
	}

	@Override
	public UserDetail getUser(int eid) {
		return userDAO.getUser(eid);
		
	}

	@Override
	public boolean updateUser(UserDetail u) {
		
		return userDAO.updateUser(u);
	}

	@Override
	public boolean deleteUser(int eid) {
		
		return userDAO.deleteUser(eid);
	}

	@Override
	public List<UserDetail> listUsers() {
		
		return userDAO.listUsers();
	}

}
