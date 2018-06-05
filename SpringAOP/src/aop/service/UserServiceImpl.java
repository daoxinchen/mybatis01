package aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aop.dao.UserDao;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser() {
		userDao.addUser();
		//int i = 1/0;
	}

	public void updateUser(){
		userDao.updateUser();
	}

	public String getUsername() {
		return userDao.getUsername();
	}


}
