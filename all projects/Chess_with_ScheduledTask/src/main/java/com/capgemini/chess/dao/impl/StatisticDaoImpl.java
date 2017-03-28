package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.service.mapper.StatisticMapper;
import com.capgemini.chess.service.to.StatisticTO;

@Repository
public class StatisticDaoImpl implements StatisticDao {

	private List<StatisticEntity> statistic = new ArrayList<>();

	public StatisticDaoImpl() {

		addStatistic();
	}

	private void addStatistic() {

		statistic.add(new StatisticEntity(1, 19, 623, 11));
		statistic.add(new StatisticEntity(1, 20, 582, 1));
		statistic.add(new StatisticEntity(2, 18, 766, 13));
		statistic.add(new StatisticEntity(2, 17, 888, 18));
		statistic.add(new StatisticEntity(3, 16, 965, 3));
		statistic.add(new StatisticEntity(3, 15, 987, 5));
		statistic.add(new StatisticEntity(4, 14, 1024, 8));
		statistic.add(new StatisticEntity(4, 13, 1111, 20));
		statistic.add(new StatisticEntity(5, 12, 1236, 15));
		statistic.add(new StatisticEntity(5, 11, 1298, 16));
		statistic.add(new StatisticEntity(6, 10, 1322, 9));
		statistic.add(new StatisticEntity(6, 9, 1345, 10));
		statistic.add(new StatisticEntity(7, 8, 1410, 19));
		statistic.add(new StatisticEntity(7, 7, 1478, 2));
		statistic.add(new StatisticEntity(8, 6, 1513, 17));
		statistic.add(new StatisticEntity(8, 5, 1555, 4));
		statistic.add(new StatisticEntity(9, 4, 1616, 14));
		statistic.add(new StatisticEntity(9, 3, 1622, 6));
		statistic.add(new StatisticEntity(10, 2, 1817, 12));
		statistic.add(new StatisticEntity(10, 1, 1923, 7));

	}

	@Override
	public StatisticTO getMyStatisticById(long userId) {

		for (StatisticEntity readStatistic : statistic) {
			if (readStatistic.getUserId() == userId)
				return StatisticMapper.map(readStatistic);

		}
		return null;

	}

}
