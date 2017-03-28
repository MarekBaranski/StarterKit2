package com.capgemini.chess.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.service.to.MatchTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = daoConfig.class)
public class MatchDaoImplTest {

	@Autowired
	private MatchDao matchDao;

	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(matchDao);

	}

	@Test
	public void shouldFindMatchById() {

		// when
		MatchTO findMatch = matchDao.getMatchById(9);
		// than
		assertNotNull(findMatch);

	}

	@Test
	public void shouldNotFindMatchById() {

		// when
		MatchTO findMatch = matchDao.getMatchById(22);
		// than
		assertNull(findMatch);

	}

}
