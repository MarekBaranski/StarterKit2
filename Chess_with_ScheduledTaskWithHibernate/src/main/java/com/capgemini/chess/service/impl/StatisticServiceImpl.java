package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.StatisticService;
import com.capgemini.chess.service.mapper.StatisticMapper;
import com.capgemini.chess.service.to.StatisticTO;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticDao statisticDao;

	@Override
	public StatisticTO showStatisticById(long userId) throws ChessException {
		return statisticDao.showStatisticById(userId);
	}

	@Override
	public List<StatisticTO> showRanking() {
		return statisticDao.showRanking();
	}

}
