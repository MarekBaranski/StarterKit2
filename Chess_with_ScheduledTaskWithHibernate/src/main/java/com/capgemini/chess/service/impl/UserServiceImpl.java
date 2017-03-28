package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UsersDao;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UsersDao userDao;

	@Override
	public UserProfileTO findProfileById(long id) throws ChessException {
		if (userDao.findProfileById(id)==null) {
			throw new ChessException(ChessException.PROFILENOTFOUND);
		} else
			return userDao.findProfileById(id);
	}
	
	@Override
	public UserUpdateTO findProfileToUpdateById(long id) throws ChessException {
		if (userDao.findProfileById(id)==null) {
			throw new ChessException(ChessException.PROFILENOTFOUND);
		} else
			return userDao.findProfileToUpdateById(id);
	}

	@Override
	public UserUpdateTO updateProfile(UserUpdateTO userUpdateProfile) {
		return userDao.updateProfile(userUpdateProfile);
	}


	

}
