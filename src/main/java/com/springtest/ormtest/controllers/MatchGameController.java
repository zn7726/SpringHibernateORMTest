package com.springtest.ormtest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.ormtest.entities.matchgame.Game;
import com.springtest.ormtest.entities.matchgame.GameScore;
import com.springtest.ormtest.entities.matchgame.Match;
import com.springtest.ormtest.entities.matchgame.Player;
import com.springtest.ormtest.repos.MatchRepository;
import com.springtest.ormtest.repos.PlayerRepository;

@RestController
@RequestMapping("/match")
public class MatchGameController {

	@Autowired
	private MatchRepository matchRepo;
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public Match createMatch(){
		final String player1Name = "Player 1";
		final String player2Name = "Player 2";
		
		Player player1 = playerRepo.findByPlayerName(player1Name);
		if(player1 == null)
			player1 = new Player("player 1");
		
		Player player2 = playerRepo.findByPlayerName(player2Name);
		if(player2 == null)
			player2 = new Player("player 2");
		
		GameScore gs1 = new GameScore(player1, 21);
		GameScore gs2 = new GameScore(player2, 1);
		Game g1 = new Game(1);
		g1.addGameScore(gs1);
		g1.addGameScore(gs2);
		g1.setWinner(player1);

		GameScore gs3 = new GameScore(player1, 21);
		GameScore gs4 = new GameScore(player2, 1);
		Game g2 = new Game(2);
		g2.addGameScore(gs3);
		g2.addGameScore(gs4);
		g2.setWinner(player1);
		
		Match match = new Match();
		match.addGame(g1);
		match.addGame(g2);
		match.setWinner(player1);
		match.addPlayer(player1);
		match.addPlayer(player2);
		
		matchRepo.save(match);
		
		System.out.println("match saved with id = " + match.getMatchId());
		
		return match;
	}
	
/*
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	List<Employee> getEmployeeById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		
		return employeeRepo.findAll(new ArrayList<Integer>(){{
			add(id);
		}});
	}
	
	@RequestMapping(value="/byName", method=RequestMethod.GET)
	Employee getEmployeeByName(@RequestParam("name") String name){
		
		// return employeeRepo.findOne(id);
		
		return employeeRepo.findByName(name);
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	Employee updateEmployeeById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(id);
		emp.setName(emp.getName()+"_NEW");
		employeeRepo.save(emp);
		
		return employeeRepo.findOne(id);
	}
	
	@RequestMapping(value="/supervisor/{id}", method=RequestMethod.GET)
	public @ResponseBody String getEmployeeSupervisorById(@PathVariable Integer id){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(id);
				
		return "supervior name is: " + emp.getSupervisor().getName();
	}
	
	@RequestMapping(value="/build", method=RequestMethod.GET)
	public @ResponseBody String createEmpWithSupervisor(){
		
		// return employeeRepo.findOne(id);
		Employee emp = employeeRepo.findOne(1);
		
		Employee sup = new Employee();
		sup.setName("a supervisor");

		emp.setSupervisor(sup);
		
		employeeRepo.save(emp);
		
		return "supervior name is: (" + emp.getSupervisor().getId() + ") - " + emp.getSupervisor().getName();
	}
	*/

}
