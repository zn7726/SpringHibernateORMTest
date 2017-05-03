package com.springtest.ormtest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtest.ormtest.entities.Employee;
import com.springtest.ormtest.entities.matchgame.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
	
}
