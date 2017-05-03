package com.springtest.ormtest.entities.matchgame;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="games")
public class Game {
	
	@Id
	@GeneratedValue
	private Integer gameId;
	
	private Integer gameSeq;
	
	@ManyToOne
	@JoinColumn(name="match_id")
	@JsonIgnore
	private Match match;
	
	@OneToMany(mappedBy="game", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Set<GameScore> scores;
	
	@ManyToOne
	private Player winner;
	
	public Game(){}
	
	public Game(Integer gameSeq) {
		super();
		this.gameSeq = gameSeq;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameSeq() {
		return gameSeq;
	}

	public void setGameSeq(Integer gameSeq) {
		this.gameSeq = gameSeq;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Set<GameScore> getScores() {
		return scores;
	}

	public void setScores(Set<GameScore> scores) {
		this.scores = scores;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public void addGameScore(GameScore gs){
		if(this.scores == null)
			this.scores = new HashSet<GameScore>();
		
		this.scores.add(gs);
		gs.setGame(this);
	}
}
