package com.capgemini.chess.dao;

import com.capgemini.chess.service.to.StatisticTO;

public interface StatisticDao {

	public StatisticTO getMyStatisticById(long userId);

}
