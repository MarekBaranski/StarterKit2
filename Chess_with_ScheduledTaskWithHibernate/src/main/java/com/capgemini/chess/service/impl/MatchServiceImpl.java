package com.capgemini.chess.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.MatchDao;
import com.capgemini.chess.dao.StatisticDao;
import com.capgemini.chess.enumerated.ResultMatch;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.MatchService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.StatisticTO;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	@Autowired
	private StatisticDao statisticDao;

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
	public MatchTO addNewMatch(MatchTO match) throws ChessException {

		StatisticTO statistic = new StatisticTO();
		StatisticTO statistic2 = new StatisticTO();
		statistic = statisticDao.showStatisticById(match.getUser1().getId());
		statistic2 = statisticDao.showStatisticById(match.getUser2().getId());

		if (match.getResult() == ResultMatch.WIN1) {
			long points = statisticDao.showStatisticById(match.getUser1().getId()).getPoints();

			statistic.setPoints(points + 10);

			statisticDao.updateStatistic(statistic);

			long pointsLevel = statistic.getPoints();
			statistic.setLevel(pointsLevel / 100);
			statisticDao.updateStatistic(statistic);

		} else if (match.getResult() == ResultMatch.WIN2) {
			long points = statisticDao.showStatisticById(match.getUser2().getId()).getPoints();

			statistic2.setPoints(points + 10);
			statisticDao.updateStatistic(statistic2);
		} else {
			long points = statisticDao.showStatisticById(match.getUser1().getId()).getPoints();
			long points2 = statisticDao.showStatisticById(match.getUser2().getId()).getPoints();

			statistic.setPoints(points + 5);
			statistic2.setPoints(points2 + 5);
			statisticDao.updateStatistic(statistic);
			statisticDao.updateStatistic(statistic2);
		}

		return matchDao.addNewMatch(match);

	}

}
