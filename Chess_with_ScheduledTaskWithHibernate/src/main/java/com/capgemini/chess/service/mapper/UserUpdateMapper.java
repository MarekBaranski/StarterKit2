package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

public class UserUpdateMapper {
	
	public static UserUpdateTO map(UserEntity userEntity) {
		if (userEntity != null) {
			UserUpdateTO userUpdateTO = new UserUpdateTO();
			userUpdateTO.setLogin(userEntity.getLogin());
			userUpdateTO.setPassword(userEntity.getPassword());
			userUpdateTO.setName(userEntity.getName());
			userUpdateTO.setSurname(userEntity.getSurname());
			userUpdateTO.setEmail(userEntity.getEmail());
			userUpdateTO.setAboutMe(userEntity.getAboutMe());
			userUpdateTO.setLifeMotto(userEntity.getLifeMotto());
			return userUpdateTO;
		}
		return null;
	}

	public static UserEntity map(UserUpdateTO userUpdateTO) {
		if (userUpdateTO != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setLogin(userUpdateTO.getLogin());
			userEntity.setPassword(userUpdateTO.getPassword());
			userEntity.setName(userUpdateTO.getName());
			userEntity.setSurname(userUpdateTO.getSurname());
			userEntity.setEmail(userUpdateTO.getEmail());
			userEntity.setAboutMe(userUpdateTO.getAboutMe());
			userEntity.setLifeMotto(userUpdateTO.getLifeMotto());
			return userEntity;
		}
		return null;
	}

	public static UserEntity update(UserEntity userEntity, UserUpdateTO userUpdateTO) {
		if (userUpdateTO != null && userEntity != null) {
			userEntity.setLogin(userUpdateTO.getLogin());
			userEntity.setPassword(userUpdateTO.getPassword());
			userEntity.setName(userUpdateTO.getName());
			userEntity.setSurname(userUpdateTO.getSurname());
			userEntity.setEmail(userUpdateTO.getEmail());
			userEntity.setAboutMe(userUpdateTO.getAboutMe());
			userEntity.setLifeMotto(userUpdateTO.getLifeMotto());

		}
		return userEntity;
	}

	public static List<UserProfileTO> map2TOs(List<UserEntity> userEntities) {
		return userEntities.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

	public static List<UserEntity> map2Entities(List<UserProfileTO> userTOs) {
		return userTOs.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

}
