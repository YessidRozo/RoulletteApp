package com.roullette.services;

import org.springframework.stereotype.Service;

import com.roullette.dto.BetDTO;
@Service
public interface BetServiceI {
	
	public String createBet(Long idUser,BetDTO betDto);
}
