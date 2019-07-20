package com.niit.SkillMapBackend.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.niit.SkillMapBackend.model.UserDetail;

@Repository("userDAO")
public interface UserDao {
	public boolean isEmailUnique(int eid);
	public boolean registerCustomer(UserDetail u) ;
	UserDetail getUser(int eid);
	boolean updateUser(UserDetail u);
	boolean deleteUser(int eid);
	List<UserDetail> listUsers();
}
