package com.capgemini.chess.service;

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
public class StatisticServiceTest {

	@Autowired
	private StatisticService statisticService;

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
		assertEquals(1025, points);

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

}
