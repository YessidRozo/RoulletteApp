package com.roullette.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roullete.cons.Constant;
import com.roullette.dto.BetDTO;
import com.roullette.entity.Bet;
import com.roullette.entity.Roullette;
import com.roullette.repository.BetRepository;
import com.roullette.repository.RoulletteRepository;
import com.roullette.services.BetServiceI;

@Service
public class BetService implements BetServiceI {

	@Autowired
	private BetRepository betRepository;
	@Autowired
	private RoulletteRepository roulletteRepository;

	@Override
	public String createBet(Long idUser, BetDTO betDto) {

		ModelMapper modelMapper = new ModelMapper();
		Bet bet = modelMapper.map(betDto, Bet.class);
		bet.setId_user(idUser);
		if (!(Constant.NUMBER.equals(bet.getBet_type()) || Constant.COLOR.equals(bet.getBet_type()))) {
			return "tipo de apuesta invalido N - C";
		}
		if (Constant.COLOR.equals(bet.getBet_type())) {
			if (!(Constant.BLACK.equals(bet.getColor_option()) || Constant.RED.equals(bet.getColor_option()))) {
				return "solo admite color R - N";
			}
		}
		if (Constant.NUMBER.equals(bet.getBet_type())) {
			if (bet.getNumber_option() == null) {
				return "numero no puede ser nulo";
			}
			if (bet.getNumber_option().compareTo(BigDecimal.ZERO) < 0
					|| bet.getNumber_option().compareTo(new BigDecimal(36)) > 0) {
				return "valor apuesta entre 0 y 36";
			}
		}
		if (Constant.BET_MAX_VALUE.compareTo(bet.getBet_value()) < 0) {
			return "Maximo valor permitido es 10000";
		}
		if (bet.getIdroullette() == null) {
			return "numero de ruleta obligatorio";
		}
		return makeBet(bet);
	}
	private String makeBet (Bet bet) {
	Optional<Roullette> optional = roulletteRepository.findById(bet.getIdroullette());
	if (optional.isPresent()) {
		if (Constant.OPEN.equals(optional.get().getState())) {
			betRepository.save(bet);
			return "apuesta exitosa";
		} else {
			return "ruleta cerrada";
		}
	}
	return "no existe ruleta";
	}

}
