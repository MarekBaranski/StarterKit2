package com.capgemini.chess.dao;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

public interface UsersDao {

	public UserProfileTO findProfileById(long id) throws ChessException;

//	public void updateProfile(UserUpdateTO userUpdateProfile);
	public UserUpdateTO updateProfile(UserUpdateTO userUpdateProfile);
	

	
	

}
