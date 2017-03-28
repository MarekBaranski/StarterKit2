package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

public class MatchMapper {

	public static MatchTO map(MatchEntity matchEntity) {

		if (matchEntity != null) {
			MatchTO matchTO = new MatchTO();
			matchTO.setDrawn(matchEntity.isDrawn());
			matchTO.setWinnerId(matchEntity.getWinnerId());
			matchTO.setMatchId(matchEntity.getMatchId());
			matchTO.setUserId(matchEntity.getUserId());
			matchTO.setUserId2(matchEntity.getUserId2());
			return matchTO;
		}
		return null;
	}

	public static MatchEntity map(MatchTO matchTO) {

		if (matchTO != null) {

			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setDrawn(matchTO.isDrawn());
			matchEntity.setWinnerId(matchTO.getWinnerId());
			matchEntity.setMatchId(matchTO.getMatchId());
			matchEntity.setUserId(matchTO.getUserId());
			matchEntity.setUserId2(matchTO.getUserId2());
			return matchEntity;

		}
		return null;
	}

	public static MatchEntity update(MatchEntity matchEntity, MatchTO matchTO) {
		if (matchTO != null && matchEntity != null) {
			matchEntity.setDrawn(matchTO.isDrawn());
			matchEntity.setWinnerId(matchTO.getWinnerId());
			matchEntity.setMatchId(matchTO.getMatchId());
			matchEntity.setUserId(matchTO.getUserId());
			matchEntity.setUserId2(matchTO.getUserId2());

		}
		return matchEntity;

	}

	public static List<MatchTO> map2TOs(List<MatchEntity> matchEntities) {
		return matchEntities.stream().map(MatchMapper::map).collect(Collectors.toList());
	}

	public static List<MatchEntity> map2Entities(List<MatchTO> matchTOs) {
		return matchTOs.stream().map(MatchMapper::map).collect(Collectors.toList());
	}
}
