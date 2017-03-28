package com.capgemini.chess.dao;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UsersDao {

	public UserProfileTO getProfileById(long id);

	public void editUser(UserProfileTO user);

	public UserProfileTO changePassword(long id, String password);

	public void deleteUserById(long id);

}
