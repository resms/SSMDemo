package com.resms.ssm.test.auth.dao;

import static org.junit.Assert.assertTrue;

import com.resms.ssm.auth.dao.UserDao;
import org.dom4j.util.UserDataDocumentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.resms.ssm.auth.bean.User;
import com.resms.ssm.auth.service.UserService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-mybatis.xml","classpath:activemq.xml" })
public class UserDaoTest {
	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Test
	public void getModel()
	{
		User u = userService.getUserById(1);
		System.out.println(u.getUserName());
		assertTrue(u.getUserName().equals("测试"));
	}

	@Test
	public void getAll()
	{
		List<User> users = userDao.getAll();
		System.out.println(users.size());
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
