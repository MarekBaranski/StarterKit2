package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MatchDaoImpl implements MatchDao {

	private List<MatchEntity> match = new ArrayList<>();

	public MatchDaoImpl() {

		addMatch();
	}

	private void addMatch() {

		match.add(new MatchEntity(1, 15, false, 1, 15));
		match.add(new MatchEntity(2, 0, true, 2, 16));
		match.add(new MatchEntity(3, 17, false, 3, 17));
		match.add(new MatchEntity(4, 10, false, 10, 11));
		match.add(new MatchEntity(5, 9, false, 9, 12));
		match.add(new MatchEntity(6, 0, true, 4, 5));
		match.add(new MatchEntity(7, 0, true, 6, 20));
		match.add(new MatchEntity(8, 7, false, 18, 7));
		match.add(new MatchEntity(9, 13, false, 19, 13));
		match.add(new MatchEntity(10, 8, false, 8, 14));
	}

	@Override
	public MatchTO getMatchById(long matchId) {

		for (MatchEntity readMatch : match) {
			if (readMatch.getMatchId() == matchId)
				return MatchMapper.map(readMatch);

		}
		return null;

	}

}
