package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

public interface UserService {

	public UserProfileTO showProfileById(long id);
	
	public UserUpdateTO updateProfile(UserUpdateTO userUpdateProfile);

	
	

}
