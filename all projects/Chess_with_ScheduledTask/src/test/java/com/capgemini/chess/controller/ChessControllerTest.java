package com.capgemini.chess.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.service.StatisticService;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserProfileTO;

@SpringApplicationConfiguration(ChessApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ChessControllerTest {

	private MockMvc mockMvc;

	@Mock
	UserService userService;

	@Mock
	StatisticService statisticService;

	@Autowired
	ChessController chessController;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.reset(this.userService);
		Mockito.reset(this.statisticService);

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

		ReflectionTestUtils.setField(chessController, "userService", userService);
		ReflectionTestUtils.setField(chessController, "statisticService", statisticService);
	}
	
	@Test
	public void testShouldGetStatisticById() throws Exception {

		StatisticTO statisticTO = new StatisticTO(6, 10, 1322, 9);

		Mockito.when(statisticService.getMyStatisticById(statisticTO.getUserId())).thenReturn(statisticTO);

		ResultActions response = this.mockMvc.perform(get("/player/findStatistic?idStat=9"));

		response.andExpect(status().isOk())
				.andExpect(jsonPath("$.level").value((int) statisticTO.getLevel()))
				.andExpect(jsonPath("$.position").value((int) statisticTO.getPosition()))
				.andExpect(jsonPath("$.points").value((int) statisticTO.getPoints()))
				.andExpect(jsonPath("$.userId").value((int) statisticTO.getUserId()));

	}

	@Test
	public void testShouldGetProfileById() throws Exception {

		UserProfileTO userProfileTO = new UserProfileTO(2L, "dwa", "b2", "UserDwa", "Drugi", "dwa@wp.pl",
				"lubie bardzo szachy", "Gram od urodzenia");

		Mockito.when(userService.getProfileById(userProfileTO.getId())).thenReturn(userProfileTO);

		ResultActions response = this.mockMvc.perform(get("/player?idUser=2"));

		response.andExpect(status().isOk()).andExpect(jsonPath("id").value((int) userProfileTO.getId()))
				.andExpect(jsonPath("$.login").value(userProfileTO.getLogin()))
				.andExpect(jsonPath("$.password").value(userProfileTO.getPassword()))
				.andExpect(jsonPath("$.name").value(userProfileTO.getName()))
				.andExpect(jsonPath("$.surname").value(userProfileTO.getSurname()))
				.andExpect(jsonPath("$.email").value(userProfileTO.getEmail()))
				.andExpect(jsonPath("$.aboutMe").value(userProfileTO.getAboutMe()))
				.andExpect(jsonPath("$.lifeMotto").value(userProfileTO.getLifeMotto()));

	}

	@Test
	public void testShouldGetNewPassword() throws Exception {

		UserProfileTO userProfileTO = new UserProfileTO(2L, "dwa", "nowehaselko", "UserDwa", "Drugi", "dwa@wp.pl",
				"lubie bardzo szachy", "Gram od urodzenia");

		Mockito.when(userService.changePassword(userProfileTO.getId(), "nowehaselko")).thenReturn(userProfileTO);

		ResultActions response = this.mockMvc.perform(post("/player?id=2&password=nowehaselko"));

		response.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value((int) userProfileTO.getId()))
				.andExpect(jsonPath("$.login").value(userProfileTO.getLogin()))
				.andExpect(jsonPath("$.password").value(userProfileTO.getPassword()))
				.andExpect(jsonPath("$.name").value(userProfileTO.getName()))
				.andExpect(jsonPath("$.surname").value(userProfileTO.getSurname()))
				.andExpect(jsonPath("$.email").value(userProfileTO.getEmail()))
				.andExpect(jsonPath("$.aboutMe").value(userProfileTO.getAboutMe()))
				.andExpect(jsonPath("$.lifeMotto").value(userProfileTO.getLifeMotto()));

	}

	@Test
	public void testShouldDeleteUserBiId() throws Exception {

		ResultActions response = this.mockMvc.perform(delete("/player?idDelete=3"));

		response.andExpect(status().isOk());

	}

}
