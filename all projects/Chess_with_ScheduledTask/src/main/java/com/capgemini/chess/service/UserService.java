package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UserService {

	public UserProfileTO getProfileById(long id);

	public void editUser(UserProfileTO user);
	
	public UserProfileTO changePassword(long id, String password);
	
	public void deleteUserById(long id);
	

}
