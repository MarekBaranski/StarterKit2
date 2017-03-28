package com.capgemini.chess.dao;

import com.capgemini.chess.service.to.MatchTO;

public interface MatchDao {

	public MatchTO getMatchById(long matchId);
	
}
