package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UsersDao;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UsersDao userDao;
	
	

	@Override
	public UserProfileTO getProfileById(long id) {
		return userDao.getProfileById(id);
	}

	@Override
	public void editUser(UserProfileTO user) {

		userDao.editUser(user);

	}

	@Override
	public UserProfileTO changePassword(long id, String password) {
		return userDao.changePassword(id, password);
	}
	
	@Override
	public void deleteUserById(long id) {
	userDao.deleteUserById(id);
	}


}
