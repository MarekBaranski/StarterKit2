package com.capgemini.chess.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.StatisticTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StatisticDaoImplTest {

	@Autowired
	private StatisticDao statisticDao;


	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(statisticDao);

	}

	@Test
	public void testShouldFindStatisticById() throws ChessException {

		// when
		StatisticTO findStatistic = statisticDao.showStatisticById(5L);

		long points = findStatistic.getPoints();
		// than
		assertNotNull(points);
		assertEquals(1024, points);

	}
	
	@SuppressWarnings("unused")
	@Test (expected = ChessException.class)
	public void testShouldNotFindStatisticByIdButIdIsNull() throws ChessException{

		// when
		StatisticTO findStatistic = statisticDao.showStatisticById(23L);

		long points = findStatistic.getPoints();
		// than
		fail("This method should throw SomeException");

	}
	
	@Test
	public void testShouldShowRanking() {
		// given
		
		// when
		List<StatisticTO> statisticTO = statisticDao.showRanking();
		// then

		assertFalse(statisticTO.isEmpty());
		assertEquals(6,statisticTO.get(2).getUserEntity().getId());
	
	}

}
