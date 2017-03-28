package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.MatchService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	@Override
	public MatchTO showMatchById(long matchId) throws ChessException {
		return matchDao.showMatchById(matchId);
	}

	@Override
	public List<MatchTO> showHistoryOfMatch() {
		return matchDao.showHistoryOfMatch();
	}

	@Override
	public List<MatchTO> showMatchWhereResultIsDrawn() {
		return matchDao.showMatchWhereResultIsDrawn();
	}

	@Override
	public List<MatchTO> showAllMatchForUserById(long userId) {
		return matchDao.showAllMatchForUserById(userId);
	}

	@Override
	public MatchTO addNewMatch(MatchTO match) {
		return matchDao.addNewMatch(match);
	}

}
