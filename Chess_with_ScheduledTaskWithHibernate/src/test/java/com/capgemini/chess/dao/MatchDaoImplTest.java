package com.capgemini.chess.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
import com.capgemini.chess.service.to.UserUpdateTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MatchDaoImplTest {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private MatchDao matchDao;

	@Autowired
	private UsersDao userDao;

	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(matchDao);

	}

	@Test
	public void shouldFindMatchById() throws ChessException {

		// when
		MatchTO match = matchDao.showMatchById(9);
		// than
		assertNotNull(match);
		assertEquals(ResultMatch.WIN2, match.getResult());

	}

	@SuppressWarnings("unused")
	@Test(expected = ChessException.class)
	public void shouldNotFindMatchById() throws ChessException {

		// when
		MatchTO findMatch = matchDao.showMatchById(22);
		// than
		fail("This method should throw SomeException");
	}

	@Test
	public void testShouldShowHistoryOfMatchs() {
		// given

		// when
		List<MatchTO> matchTO = matchDao.showHistoryOfMatch();
		// then

		assertFalse(matchTO.isEmpty());

	}

	@Test
	public void testShouldShowAllMatchForOneUserById() {
		// given
		long userId = 1;
		// when
		List<MatchTO> matchTO = matchDao.showAllMatchForUserById(userId);
		// then

		assertFalse(matchTO.isEmpty());
		assertEquals(2, matchTO.size());

	}

	@Test
	public void testShouldShowAllDrawnMatch() {
		// given

		// when
		List<MatchTO> matchTO = matchDao.showMatchWhereResultIsDrawn();
		// then

		assertFalse(matchTO.isEmpty());
		assertEquals(2, matchTO.size());

	}

	@Test
	public void updateProfile() throws ChessException {

		UserUpdateTO profile = new UserUpdateTO();

		profile = userDao.findProfileToUpdateById(5L);
		// then
		String actualMotto = profile.getLifeMotto();

		// when

		profile.setEmail("piecipol@wp.pl");
		profile.setLifeMotto("najbardziej to lubię grać");
		userDao.updateProfile(profile);
		em.flush();
		em.clear();
		

		// then
		String newMotto = profile.getLifeMotto();

		assertEquals("Gram bo moj brat gra", actualMotto);
		assertEquals("najbardziej to lubię grać", newMotto);
		assertNotEquals(actualMotto, profile.getLifeMotto());
		assertNotEquals(profile.getEmail(), "pięć@wp.pl");
	}

}
