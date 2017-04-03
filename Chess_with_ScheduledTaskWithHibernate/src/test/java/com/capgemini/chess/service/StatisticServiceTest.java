package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.enumerated.ResultMatch;
import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StatisticServiceTest {


	@Autowired
	private EntityManager em;
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private UserService userService;
	

	@Autowired
	private MatchService matchService;

	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(statisticService);

	}

	@Test
	public void testShouldFindStatisticById() throws ChessException {

		// when
		StatisticTO findStatistic = statisticService.showStatisticById(5L);

		long points = findStatistic.getPoints();
		// than
		assertNotNull(points);
		assertEquals(1470, points);

	}

	@SuppressWarnings("unused")
	@Test(expected = ChessException.class)
	public void testShouldNotFindStatisticByIdButIdIsNull() throws ChessException {

		// when
		StatisticTO findStatistic = statisticService.showStatisticById(23L);

		long points = findStatistic.getPoints();
		// than
		fail("This method should throw SomeException");

	}

	@Test
	public void testShouldShowRanking() {
		// given

		// when
		List<StatisticTO> statisticTO = statisticService.showRanking();
		// then

		assertFalse(statisticTO.isEmpty());
		assertEquals(6, statisticTO.get(2).getUserEntity().getId());
		

	}
	
	@Test
	public void testShouldUpdateRanking() throws ChessException {
		// given
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(4L);
		UserProfileTO user2 = userService.findProfileById(5L);

		match.setResult(ResultMatch.WIN2);
		match.setUser1(user1);
		match.setUser2(user2);
		
		List<StatisticTO> statisticTO = statisticService.showRanking();
		
		long beforeMatchPointsForUser1 = statisticService.showStatisticById(4L).getPoints();
		long beforeMatchPointsForUser2 = statisticService.showStatisticById(5L).getPoints();
		
		long idStatisticUser1OnRankingBeforeMatch = statisticTO.get(3).getUserEntity().getId();
		// when
				
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		
		long afterMatchPointsForUser1 = statisticService.showStatisticById(4L).getPoints();
		long afterMatchPointsForUser2 = statisticService.showStatisticById(5L).getPoints();
		
		List<StatisticTO> afterMatchStatisticTO = statisticService.showRanking();
		
		long idStatisticUser1OnRankingAfterMatch = afterMatchStatisticTO.get(3).getUserEntity().getId();
		
		// then
		assertEquals(1475, beforeMatchPointsForUser1);
		assertEquals(1470, beforeMatchPointsForUser2);	
		assertFalse(statisticTO.isEmpty());
		assertEquals(1475, afterMatchPointsForUser1);
		assertEquals(1480, afterMatchPointsForUser2);
		assertNotEquals(idStatisticUser1OnRankingBeforeMatch, idStatisticUser1OnRankingAfterMatch);
		
//		assertEquals(6, statisticTO.get(2).getUserEntity().getId());

	}

}
