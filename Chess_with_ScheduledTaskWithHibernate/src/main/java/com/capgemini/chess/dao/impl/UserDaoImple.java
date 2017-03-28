package com.capgemini.chess.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UsersDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.mapper.UserUpdateMapper;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

@Repository
public class UserDaoImple extends AbstractDao<UserEntity, Long> implements UsersDao {

	@Override
	public UserProfileTO findProfileById(long id) throws ChessException {
		if (findOne(id)==null) {
			throw new ChessException(ChessException.PROFILENOTFOUND);
		} else
			return UserProfileMapper.map(findOne(id));

	}

	@Override
	public UserUpdateTO updateProfile(UserUpdateTO userUpdateProfile) {
		return UserUpdateMapper.map(save(UserUpdateMapper.map(userUpdateProfile)));
	}

	// @Override
	// public void updateProfile(UserUpdateTO userUpdateProfile) {
	// save(UserUpdateMapper.map(userUpdateProfile));
	//
	// }

}
