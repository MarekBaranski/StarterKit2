package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.StatisticTO;

public interface StatisticDao {

	
	public StatisticTO showStatisticById(long userId) throws ChessException;
	
	public List <StatisticTO> showRanking();


}
