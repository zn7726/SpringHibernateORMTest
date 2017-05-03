package com.springtest.ormtest.entities.matchgame;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="matchs")
public class Match {
	@Id
	@GeneratedValue
	private Integer matchId;
	
	@OneToOne
	@JoinColumn(name="winner_id")
	private Player winner;
	
	@ManyToMany(mappedBy="matchesPlayed", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@OrderBy("name")
	private List<Player> players;
	
	@OneToMany(mappedBy="match", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@OrderBy("game_seq")
	private List<Game> games;

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public void addGame(Game game){
		if(this.games == null)
			this.games = new LinkedList<Game>();
		
		this.games.add(game);
		game.setMatch(this);
	}
	
	public void addPlayer(Player player){
		if(this.players == null)
			this.players = new LinkedList<>();
		
		if(!this.players.contains(player))
			this.players.add(player);
		
		player.addMatchPlayed(this);
	}
}
