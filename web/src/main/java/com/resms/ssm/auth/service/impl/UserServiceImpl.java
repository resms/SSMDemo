package com.resms.ssm.auth.service.impl;

import com.resms.ssm.auth.dto.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resms.ssm.auth.bean.User;
import com.resms.ssm.auth.dao.UserDao;
import com.resms.ssm.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
