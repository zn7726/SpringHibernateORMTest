package com.springtest.ormtest.entities.matchgame;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="players")
public class Player {
	@Id
	@GeneratedValue
	Integer playerId;
	
	@Column(name="player_name")
	String playerName;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JsonIgnore
	@JoinTable(
			name="match_player",
			joinColumns=@JoinColumn(name="player_id"),	// new column name to ref ID in this table
			inverseJoinColumns=@JoinColumn(name="match_id")	// new column name to ref ID of the other table
		)	
	Set<Match> matchesPlayed;
	
	public Player(){}

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Set<Match> getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(Set<Match> matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	
	// always add match_player from match side
	public void addMatchPlayed(Match match){
		if(this.matchesPlayed == null)
			this.matchesPlayed = new HashSet<>();
		
		if(!this.matchesPlayed.contains(match))
			this.matchesPlayed.add(match);
		
	}
}
