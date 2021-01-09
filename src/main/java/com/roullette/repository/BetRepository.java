package com.roullette.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roullette.entity.Bet;
@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
	
	List<Bet> findByIdroullette(Long idroullette);
	
	
}	
