package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public class UserProfileMapper {

	public static UserProfileTO map(UserEntity userEntity) {
		if (userEntity != null) {
			UserProfileTO userProfileTO = new UserProfileTO();
			userProfileTO.setAboutMe(userEntity.getAboutMe());
			userProfileTO.setEmail(userEntity.getEmail());
			userProfileTO.setId(userEntity.getId());
			userProfileTO.setLifeMotto(userEntity.getLifeMotto());
			userProfileTO.setLogin(userEntity.getLogin());
			userProfileTO.setName(userEntity.getName());
			userProfileTO.setPassword(userEntity.getPassword());
			userProfileTO.setSurname(userEntity.getSurname());
			return userProfileTO;
		}
		return null;
	}

	public static UserEntity map(UserProfileTO userProfileTO) {
		if (userProfileTO != null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setAboutMe(userProfileTO.getAboutMe());
			userEntity.setEmail(userProfileTO.getEmail());
			userEntity.setId(userProfileTO.getId());
			userEntity.setLifeMotto(userProfileTO.getLifeMotto());
			userEntity.setLogin(userProfileTO.getLogin());
			userEntity.setName(userProfileTO.getName());
			userEntity.setPassword(userProfileTO.getPassword());
			userEntity.setSurname(userProfileTO.getSurname());
			return userEntity;
		}
		return null;
	}

	public static UserEntity update(UserEntity userEntity, UserProfileTO userProfileTO) {
		if (userProfileTO != null && userEntity != null) {
			userEntity.setAboutMe(userProfileTO.getAboutMe());
			userEntity.setEmail(userProfileTO.getEmail());
			userEntity.setId(userProfileTO.getId());
			userEntity.setLifeMotto(userProfileTO.getLifeMotto());
			userEntity.setName(userProfileTO.getName());
			userEntity.setPassword(userProfileTO.getPassword());
			userEntity.setSurname(userProfileTO.getSurname());
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
