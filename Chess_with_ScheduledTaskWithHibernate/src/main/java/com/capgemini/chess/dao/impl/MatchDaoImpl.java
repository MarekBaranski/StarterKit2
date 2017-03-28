package com.capgemini.chess.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.enumerated.ResultMatch;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MatchDaoImpl extends AbstractDao<MatchEntity, Long> implements MatchDao {

	@Override
	public MatchTO showMatchById(long matchId) throws ChessException {

		if (findOne(matchId) == null) {
			
			throw new ChessException(ChessException.MATCHNOTFOUND);
		} else
			return MatchMapper.map(findOne(matchId));
	}

	@Override
	public List<MatchTO> showHistoryOfMatch() {

		TypedQuery<MatchEntity> query = entityManager
				.createQuery("select match from MatchEntity match order by match.id ASC", MatchEntity.class);

		return MatchMapper.map2TOs(query.getResultList());
	}

	@Override
	public List<MatchTO> showAllMatchForUserById(long userId) {
		TypedQuery<MatchEntity> query = entityManager.createQuery(
				"select match from MatchEntity match where (match.user1.id)=:userId or (match.user2.id)=:userId",
				MatchEntity.class);
		query.setParameter("userId", userId);

		return MatchMapper.map2TOs(query.getResultList());
	}

	@Override
	public List<MatchTO> showMatchWhereResultIsDrawn() {
		TypedQuery<MatchEntity> query = entityManager
				.createQuery("select match from MatchEntity match where match.result=:result", MatchEntity.class);
		query.setParameter("result", ResultMatch.DRAWN);
		return MatchMapper.map2TOs(query.getResultList());
	}

//	@Override
//	public MatchTO addNewMatch(MatchTO match) {
//		return MatchMapper.map(save(MatchMapper.map(match)));
//	}
	
	@Override
	public MatchTO addNewMatch(MatchTO match) {
		MatchEntity entity = new MatchEntity();
		entity.setUser1(entityManager.find(UserEntity.class, match.getUser1().getId()));
		entity.setUser2(entityManager.find(UserEntity.class, match.getUser2().getId()));
		return MatchMapper.map(save(MatchMapper.map(match, entity)));
	}

	
	
	
}
