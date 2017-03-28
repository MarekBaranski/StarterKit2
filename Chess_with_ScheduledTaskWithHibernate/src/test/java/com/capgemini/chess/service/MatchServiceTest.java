package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
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
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MatchServiceTest {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private MatchService matchService;
	

	@Autowired
	private StatisticService statisticService;

	@Autowired
	private UserService userService;

	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(matchService);

	}

	@Test
	public void shouldFindMatchById() throws ChessException {

		// when
		MatchTO match = matchService.showMatchById(9);
		// than
		assertNotNull(match);
		assertEquals(ResultMatch.WIN2, match.getResult());

	}

	@SuppressWarnings("unused")
	@Test(expected = ChessException.class)
	public void shouldNotFindMatchById() throws ChessException {

		// when
		MatchTO findMatch = matchService.showMatchById(22);
		// than
		fail("This method should throw SomeException");
	}

	@Test
	public void testShouldShowHistoryOfMatchs() {
		// given

		// when
		List<MatchTO> matchTO = matchService.showHistoryOfMatch();
		// then

		assertFalse(matchTO.isEmpty());

	}

	@Test
	public void testShouldShowAllMatchForOneUserById() {
		// given
		long userId = 1;
		// when
		List<MatchTO> matchTO = matchService.showAllMatchForUserById(userId);
		// then

		assertFalse(matchTO.isEmpty());
		assertEquals(2, matchTO.size());

	}

	@Test
	public void testShouldShowAllDrawnMatch() {
		// given

		// when
		List<MatchTO> matchTO = matchService.showMatchWhereResultIsDrawn();
		// then

		assertFalse(matchTO.isEmpty());
		assertEquals(2, matchTO.size());

	}

	@Test
	public void testShouldAddNewMatch() throws ChessException {
		// given
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(1);
		UserProfileTO user2 = userService.findProfileById(7);

		match.setResult(ResultMatch.WIN2);
		match.setUser1(user1);
		match.setUser2(user2);

		// when
		int sizeBefore = matchService.showHistoryOfMatch().size();
		
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		
		int sizeAfter = matchService.showHistoryOfMatch().size();
		
		
		// then
		assertEquals(++sizeBefore, sizeAfter);
		assertEquals("jeden", matchService.showHistoryOfMatch().get(9).getUser1().getLogin());
		assertEquals(10, matchService.showHistoryOfMatch().get(9).getId());

	}
	
	@Test
	public void shouldUpdateWinner1Points() throws ChessException {
		// when
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(1L);
		UserProfileTO user2 = userService.findProfileById(7L);

		match.setResult(ResultMatch.WIN1);
		match.setUser1(user1);
		match.setUser2(user2);
		long beforeMatchPoints = statisticService.showStatisticById(1L).getPoints();
		// when
				
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		// then
		long afterMatchPoints = statisticService.showStatisticById(1L).getPoints();
		assertEquals(1235, beforeMatchPoints);
		assertEquals(1245, afterMatchPoints);
	}

	@Test
	public void shouldUpdateWinner2Points() throws ChessException {
		// when
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(1L);
		UserProfileTO user2 = userService.findProfileById(7L);

		match.setResult(ResultMatch.WIN2);
		match.setUser1(user1);
		match.setUser2(user2);
		long beforeMatchPoints = statisticService.showStatisticById(7L).getPoints();
		// when
				
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		// then
		long afterMatchPoints = statisticService.showStatisticById(7L).getPoints();
		assertEquals(1410, beforeMatchPoints);
		assertEquals(1420, afterMatchPoints);
	}
	
	@Test
	public void shouldUpdateTwoWinnerPointsWhenIsDrawn() throws ChessException {
		// when
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(1L);
		UserProfileTO user2 = userService.findProfileById(7L);

		match.setResult(ResultMatch.DRAWN);
		match.setUser1(user1);
		match.setUser2(user2);
		long beforeMatchPoints1 = statisticService.showStatisticById(1L).getPoints();
		long beforeMatchPoints2 = statisticService.showStatisticById(7L).getPoints();
		// when
				
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		// then
		long afterMatchPoints1 = statisticService.showStatisticById(1L).getPoints();
		long afterMatchPoints2 = statisticService.showStatisticById(7L).getPoints();
		assertEquals(1235, beforeMatchPoints1);
		assertEquals(1410, beforeMatchPoints2);
		assertEquals(1240, afterMatchPoints1);
		assertEquals(1415, afterMatchPoints2);
	}
	
	@Test
	public void shouldUpdateWinnerLevel() throws ChessException {
		// when
		MatchTO match = new MatchTO();
		UserProfileTO user1 = userService.findProfileById(10L);
		UserProfileTO user2 = userService.findProfileById(7L);

		match.setResult(ResultMatch.WIN1);
		match.setUser1(user1);
		match.setUser2(user2);
		long beforeMatchLevel = statisticService.showStatisticById(10L).getLevel();
		// when
				
		matchService.addNewMatch(match);
		em.flush();
		em.clear();
		// then
		long afterMatchLevel = statisticService.showStatisticById(10L).getLevel();
		assertEquals(19, beforeMatchLevel);
		assertEquals(20, afterMatchLevel);
	}

	
}
