package com.niit.SkillMapBackend;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SkillMapBackend.dao.UserDao;
import com.niit.SkillMapBackend.model.UserDetail;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class UserTest {
	
	static UserDao userDAO;

	@BeforeClass
	public static void execute() {
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDao)context.getBean("userDAO");
	}
	
	
	@Test
	public void addUserTest()
	{
		UserDetail user=new UserDetail();
		user.setName("prakhya");
		user.setPhoneno("786976");
		user.setEmailid("vaishu@gmail.com");
		user.setAddress("Bangalore");
		user.setSkill("C,C++,Java");
		
		
		assertTrue("Probem in Adding the User",userDAO.registerCustomer(user));

}
	
	@Ignore
		@Test
		public void updateUserTest()
		{	
			UserDetail user=userDAO.getUser(2);
			user.setName("Jennie");
			assertTrue("Problem in Updating ",userDAO.updateUser(user));
		}
		@Ignore
		@Test
		public void deleteUserTest()
		{
			UserDetail user=userDAO.getUser(3);
			assertTrue("Problem in deleting ",userDAO.deleteUser(3));
		}
		@Ignore
		@Test
		public void listUsersTest()
		{
			List<UserDetail> listUsers=userDAO.listUsers();
			
			assertTrue("Problem in Listing",listUsers.size()>0);
			
			for(UserDetail user:listUsers)
			{
				System.out.print("User emailID:"+user.getEmailid());
				System.out.print("User FirstName:"+user.getName());
				
				System.out.println("User ContactNumber:"+user.getPhoneno());
			}
		}
		
}
