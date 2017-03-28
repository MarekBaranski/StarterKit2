package com.capgemini.chess.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dao.impl.UserDaoImple;
import com.capgemini.chess.service.to.UserProfileTO;


public class UserDaoImplTest {


	private UsersDao usersDao = new UserDaoImple();

//	@Test
//	public void testAutowiredSuccessful() {
//
//		assertNotNull(usersDao);
//
//	}

	@Test
	public void shouldFindUserById() {
		
		// when
		UserProfileTO findUser = usersDao.getProfileById(8);

		// then
		assertNotNull(findUser);

	}

	@Test
	public void shouldNotFindUserById() {

		// when
		UserProfileTO findUser = usersDao.getProfileById(12);

		// then
		assertNull(findUser);

	}

	@Test
	public void shouldTestIfProfileIsEdit() {

		// given
		UserProfileTO newUser = new UserProfileTO(7L, "dwanascie", "l12", "userDwanascie", "Dwunasty",
				"dwanascie@wp.pl", "Jestem nowym uzytkownikiem", "Ja tez lubie pograc w szachy");

		// when
		usersDao.editUser(newUser);
		UserProfileTO changeUser = usersDao.getProfileById(7L);

		// then

		assertEquals("dwanascie", changeUser.getLogin());

	}

}
