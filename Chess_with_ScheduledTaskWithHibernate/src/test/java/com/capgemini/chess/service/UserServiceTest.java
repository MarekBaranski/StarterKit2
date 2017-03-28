package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.exception.ChessException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {


	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Autowired
	UserService userService;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void shouldShowProfileById() throws ChessException {

		// when
		UserProfileTO findProfile = userService.findProfileById(2L);

		// then
		assertNotNull(findProfile);
		assertEquals("dwa@wp.pl", findProfile.getEmail());

	}

	@SuppressWarnings("unused")
	@Test(expected = ChessException.class)
	public void shouldNotShowProfileByIdButIdIsEmpty() throws ChessException {

		// when
		UserProfileTO findProfile = userService.findProfileById(12L);

		// then
		fail("This method should throw SomeException");

	}

	@SuppressWarnings("unused")
	@Test
	public void testForException() throws Exception {
		// given
		Long userId = 15L;
		// when
		thrown.expect(ChessException.class);
		thrown.expectMessage(ChessException.PROFILENOTFOUND);

		UserProfileTO findProfile = userService.findProfileById(userId);
		// then
		fail("This method should throw SomeException");

	}

	@Test
	public void updateProfile() throws ChessException {

		UserUpdateTO profile = new UserUpdateTO();

		profile = userService.findProfileToUpdateById(5L);
		// then
		String actualMotto = profile.getLifeMotto();

		// when

		profile.setEmail("piecipol@wp.pl");
		profile.setLifeMotto("najbardziej to lubię grać");
		userService.updateProfile(profile);
		em.flush();
		em.clear();
		

		// then
		String newMotto = profile.getLifeMotto();

		assertEquals("Gram bo moj brat gra", actualMotto);
		assertEquals("najbardziej to lubię grać", newMotto);
		assertNotEquals(actualMotto, profile.getLifeMotto());
		assertNotEquals(profile.getEmail(), "pięć@wp.pl");
	}

	@SuppressWarnings("unused")
	@Test(expected = ChessException.class)
	public void shouldNotUpdateProfile() throws ChessException {

		UserProfileTO profile = new UserProfileTO();

		profile = userService.findProfileById(25L);
		// then
		String actualMotto = profile.getLifeMotto();

		// when

		profile.setEmail("piecipol@wp.pl");
		profile.setLifeMotto("najbardziej to lubię grać");

		// then
		fail("This method should throw SomeException");
	}

}
