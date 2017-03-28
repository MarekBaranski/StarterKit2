package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.service.to.StatisticTO;

public class StatisticMapper {

	public static StatisticTO map(StatisticEntity statisticEntity) {
		if (statisticEntity != null) {

			StatisticTO statisticTO = new StatisticTO();

			statisticTO.setLevel(statisticEntity.getLevel());
			statisticTO.setPoints(statisticEntity.getPoints());
			statisticTO.setPosition(statisticEntity.getPosition());
			statisticTO.setUserId(statisticEntity.getUserId());
			return statisticTO;
		}
		return null;

	}

	public static StatisticEntity map(StatisticTO statisticTO) {
		if (statisticTO != null) {
			StatisticEntity statisticEntity = new StatisticEntity();
			statisticEntity.setLevel(statisticTO.getLevel());
			statisticEntity.setPoints(statisticTO.getPoints());
			statisticEntity.setPosition(statisticTO.getPosition());
			statisticEntity.setUserId(statisticTO.getUserId());
			return statisticEntity;
		}
		return null;

	}

	public static StatisticEntity update(StatisticEntity statisticEntity, StatisticTO statisticTO) {
		if (statisticTO != null && statisticEntity != null) {
			statisticEntity.setLevel(statisticTO.getLevel());
			statisticEntity.setPoints(statisticTO.getPoints());
			statisticEntity.setPosition(statisticTO.getPosition());
			statisticEntity.setUserId(statisticTO.getUserId());
		}
		return statisticEntity;

	}

	public static List<StatisticTO> map2TOs(List<StatisticEntity> statisticEntities) {
		return statisticEntities.stream().map(StatisticMapper::map).collect(Collectors.toList());
	}

	public static List<StatisticEntity> map2Entities(List<StatisticTO> statisticTOs) {
		return statisticTOs.stream().map(StatisticMapper::map).collect(Collectors.toList());
	}
}
