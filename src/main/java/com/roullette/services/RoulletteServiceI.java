package com.roullette.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.roullette.dto.ReplyDTO;
import com.roullette.dto.RoulletteDTO;
@Service
public interface RoulletteServiceI {	

	public Long createRoullette(RoulletteDTO roulletteDto);
	public String openRoullette(Long id_roullette);
	public ReplyDTO closeRoullette(Long id_roullette);	
	public List<RoulletteDTO> roulleteListing();
	
}
