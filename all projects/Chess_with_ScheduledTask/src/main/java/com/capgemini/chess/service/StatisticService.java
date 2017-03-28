package com.capgemini.chess.service;

import com.capgemini.chess.service.to.StatisticTO;

public interface StatisticService {

	public StatisticTO getMyStatisticById(long userId);

}
