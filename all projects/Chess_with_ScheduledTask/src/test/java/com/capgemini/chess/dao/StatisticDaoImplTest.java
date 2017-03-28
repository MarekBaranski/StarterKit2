package com.capgemini.chess.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.service.to.StatisticTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = daoConfig.class)
public class StatisticDaoImplTest {

	@Autowired
	private StatisticDao statisticDao;

	@Test
	public void testAutowiredSuccessful() {

		assertNotNull(statisticDao);

	}

	@Test
	public void shouldFindStatisticById() {

		// when
		StatisticTO findStatistic = statisticDao.getMyStatisticById(9);
		// than
		assertNotNull(findStatistic);

	}

	@Test
	public void shouldNotFindStatisticById() {

		// when
		StatisticTO findStatistic = statisticDao.getMyStatisticById(31);
		// than
		assertNull(findStatistic);

	}

}
