package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.service.MatchService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	@Override
	public MatchTO getMatchById(long matchId) {
		return matchDao.getMatchById(matchId);

	}

	
}
