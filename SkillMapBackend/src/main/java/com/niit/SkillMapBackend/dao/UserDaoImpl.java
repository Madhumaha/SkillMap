package com.niit.SkillMapBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SkillMapBackend.model.UserDetail;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserDaoImpl(){
			System.out.println("UserDaoImpl bean is created..");
		}
	
	public boolean isEmailUnique(String email) { 
		Session session = sessionFactory.getCurrentSession();
		//UserDetail user = (UserDetail) session.get(UserDetail.class, eid);
		String s4="from UserDetail where emailid='"+email+"'";
		Query e=sessionFactory.getCurrentSession().createQuery(s4);
		List<UserDetail> ulist=e.list();
		if (ulist.size()!=0)
			return false;
		else
			return true;
	}
	
		public boolean registerCustomer(UserDetail u) {
			System.out.println("calling register function");
			Session session=sessionFactory.getCurrentSession();
			session.save(u);
			return true;
		}

		
		public UserDetail getUser(int eid) {
			Session session=sessionFactory.getCurrentSession();
			try
			{
			UserDetail user=(UserDetail)session.get(UserDetail.class, eid);
			//SQL query select * from user where id=?
			return user;
			}
			catch(Exception e)
			{
				return null;
			}
		}
		@Override
		public boolean updateUser(UserDetail use) {
			
			Session s=sessionFactory.getCurrentSession();
			try {
			s.update(use);
			return true;
			}
			catch(Exception e1)
			{
				return false;
			}
			
			
		}
		@Override
		public boolean deleteUser(int eid) {
			UserDetail u=getUser(eid);
			Session s=sessionFactory.getCurrentSession();
			try
			{
				s.delete(u);
				return true;
			}
			catch(Exception e) {
				return false;
			}
			
		}
		
		
		
		@Override
		public List<UserDetail> listUsers() {
			String s4="from UserDetail";
			Query e=sessionFactory.getCurrentSession().createQuery(s4);
			List<UserDetail> ulist=e.list();
			return ulist;
		}
		

}