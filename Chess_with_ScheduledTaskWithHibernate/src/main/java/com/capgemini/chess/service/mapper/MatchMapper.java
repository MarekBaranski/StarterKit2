package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

public class MatchMapper {

	public static MatchTO map(MatchEntity matchEntity) {
		if (matchEntity != null) {
			MatchTO matchTO = new MatchTO();
			matchTO.setId(matchEntity.getId());
			matchTO.setResult(matchEntity.getResult());
			matchTO.setUser1(UserProfileMapper.map(matchEntity.getUser1()));
			matchTO.setUser2(UserProfileMapper.map(matchEntity.getUser2()));
			return matchTO;
		}
		return null;
	}

	public static MatchEntity map(MatchTO matchTO) {

		if (matchTO != null) {

			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setId(matchTO.getId());
			matchEntity.setResult(matchTO.getResult());
			matchEntity.setUser1(UserProfileMapper.map(matchTO.getUser1()));
			matchEntity.setUser2(UserProfileMapper.map(matchTO.getUser2()));
			return matchEntity;

		}
		return null;
	}

	public static MatchEntity update(MatchEntity matchEntity, MatchTO matchTO) {
		if (matchTO != null && matchEntity != null) {
			matchEntity.setId(matchTO.getId());
			matchEntity.setResult(matchTO.getResult());
			matchEntity.setUser1(UserProfileMapper.map(matchTO.getUser1()));
			matchEntity.setUser2(UserProfileMapper.map(matchTO.getUser2()));

		}
		return matchEntity;

	}

	public static MatchEntity map(MatchTO to, MatchEntity matchEntity) {
		if (to != null) {

			matchEntity.setId(to.getId());
			matchEntity.setUser1(UserProfileMapper.map(to.getUser1(), matchEntity.getUser1()));
			matchEntity.setUser2(UserProfileMapper.map(to.getUser2(), matchEntity.getUser2()));
			matchEntity.setResult(to.getResult());
			return matchEntity;
		} else {
			return null;
		}
	}
	

	public static List<MatchTO> map2TOs(List<MatchEntity> matchEntities) {
		return matchEntities.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

	public static List<MatchEntity> map2Entities(List<MatchTO> matchTOs) {
		return matchTOs.stream().map(MatchMapper::map).collect(Collectors.toList());
	}
}
