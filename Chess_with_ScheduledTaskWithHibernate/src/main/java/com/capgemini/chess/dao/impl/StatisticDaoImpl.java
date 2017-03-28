package com.capgemini.chess.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.dataaccess.entities.StatisticEntity;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.mapper.StatisticMapper;
import com.capgemini.chess.service.to.StatisticTO;

@Repository
public class StatisticDaoImpl extends AbstractDao<StatisticEntity, Long> implements StatisticDao {

	@Override
	public StatisticTO showStatisticById(long userId) throws ChessException {
		TypedQuery<StatisticEntity> query = entityManager.createQuery(
				"select statistic from StatisticEntity statistic where (statistic.userEntity.id)=:userId",
				StatisticEntity.class);
		query.setParameter("userId", userId);

		if (findOne(userId)==null) {

			throw new ChessException(ChessException.PROFILENOTFOUND);
		} else
			return StatisticMapper.map(query.getSingleResult());
	}
	
	

	@Override
	public List<StatisticTO> showRanking() {
		TypedQuery<StatisticEntity> query = entityManager.createQuery(
				"select statistic from StatisticEntity statistic order by statistic.points DESC",
				StatisticEntity.class);
		return StatisticMapper.map2TOs(query.getResultList());
	}

}
