package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.StatisticTO;

public interface StatisticService {

	public StatisticTO showStatisticById(long userId) throws ChessException;

	public List<StatisticTO> showRanking();

}
