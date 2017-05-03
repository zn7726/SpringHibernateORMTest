package com.springtest.ormtest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtest.ormtest.entities.matchgame.Match;
import com.springtest.ormtest.entities.matchgame.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	Player findByPlayerName(String playerName);
}
