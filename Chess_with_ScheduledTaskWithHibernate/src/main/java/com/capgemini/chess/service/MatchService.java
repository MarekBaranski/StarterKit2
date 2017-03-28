package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.MatchTO;

public interface MatchService {

	public MatchTO showMatchById(long matchId) throws ChessException;

	public List<MatchTO> showHistoryOfMatch();

	public List<MatchTO> showMatchWhereResultIsDrawn();

	public List<MatchTO> showAllMatchForUserById(long userId);

	public MatchTO addNewMatch(MatchTO match);

}
