package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.service.StatisticService;
import com.capgemini.chess.service.to.StatisticTO;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticDao statisticDao;

	@Override
	public StatisticTO getMyStatisticById(long userId) {

		return statisticDao.showStatisticById(userId);
	}

}
