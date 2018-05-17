package com.resms.ssm.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resms.ssm.auth.bean.User;
import com.resms.ssm.auth.dao.UserDao;
import com.resms.ssm.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserById(int id) {
		
		return userDao.selectByPrimaryKey(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
