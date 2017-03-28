package com.capgemini.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chess.service.StatisticService;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.to.StatisticTO;
import com.capgemini.chess.service.to.UserProfileTO;

@RestController
@RequestMapping("/player")
public class ChessController {

	@Autowired
	private StatisticService statisticService;

	@Autowired
	private UserService userService;
	
	

	@ResponseBody
	@RequestMapping(value="/findStatistic", method = RequestMethod.GET)//Sytatistic bez find
	public StatisticTO getStatistic(@RequestParam("idStat") long id) {
		return statisticService.getMyStatisticById(id);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public UserProfileTO getProfileById(@RequestParam("idUser") long id) {
		return userService.getProfileById(id);
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public UserProfileTO changePassword(@RequestParam("id")long id, @RequestParam("password")  String password) {
		return userService.changePassword(id, password);
	}

	
	 @RequestMapping(method = RequestMethod.DELETE)
	 public void deleteUserById(@RequestParam("idDelete") long id) {
	  userService.deleteUserById(id);
	 }

}
