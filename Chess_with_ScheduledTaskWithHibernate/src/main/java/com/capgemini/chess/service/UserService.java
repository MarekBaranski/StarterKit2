package com.capgemini.chess.service;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

public interface UserService {


	public UserProfileTO findProfileById(long id) throws ChessException;

	public UserUpdateTO updateProfile(UserUpdateTO userUpdateProfile);

	UserUpdateTO findProfileToUpdateById(long id) throws ChessException;
	

}
