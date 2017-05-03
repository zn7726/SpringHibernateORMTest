package com.springtest.ormtest.entities.matchgame;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="game_score")
public class GameScore {
	@Id
	@GeneratedValue
	@Column(name="score_id")
	private Integer scoreId;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	@JsonIgnore
	private Game game;
	
	@ManyToOne
	@JoinColumn(name="player_id")	
	private Player player;
	
	private Integer score;
	
	public GameScore(){}
	
		
	public GameScore(Player player, Integer score) {
		super();
		this.player = player;
		this.score = score;
	}


	public Integer getScoreId() {
		return scoreId;
	}

	public void setScoreId(Integer scoreId) {
		this.scoreId = scoreId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
