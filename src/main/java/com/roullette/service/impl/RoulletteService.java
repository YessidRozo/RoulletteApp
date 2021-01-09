package com.roullette.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roullete.cons.Constant;
import com.roullette.dto.BetFinalDTO;
import com.roullette.dto.ReplyDTO;
import com.roullette.dto.RoulletteDTO;
import com.roullette.entity.Bet;
import com.roullette.entity.Roullette;
import com.roullette.repository.BetRepository;
import com.roullette.repository.RoulletteRepository;
import com.roullette.services.RoulletteServiceI;

@Service
public class RoulletteService implements RoulletteServiceI {

	@Autowired
	private RoulletteRepository roulletteRepository;
	@Autowired
	private BetRepository betRepository;

	@Override
	public Long createRoullette(RoulletteDTO roulletteDto) {
		ModelMapper modelMapper = new ModelMapper();
		Roullette roullette = modelMapper.map(roulletteDto, Roullette.class);
		roullette = roulletteRepository.save(roullette);
		return roullette.getId_roullette();
	}

	@Override
	public String openRoullette(Long id_roullette) {
		Optional<Roullette> optional = roulletteRepository.findById(id_roullette);
		if (optional.isPresent()) {
			if (Constant.OPEN.equals(optional.get().getState())) {
				return "ruleta ya se encontraba abierta";
			}
			optional.get().setState(Constant.OPEN);
			roulletteRepository.save(optional.get());
			
			return "ruleta abierta";
		}
		
		return "no se abrio ruleta";
	}
	
	
	private ReplyDTO close (Long id_roullette) {
		Optional<Roullette> optional = roulletteRepository.findById(id_roullette);
		if (optional.isPresent()) {
			if (Constant.CLOSE.equals(optional.get().getState())) {
				return new ReplyDTO(500, "ruleta cerrada previamente", null);
			}
			optional.get().setState(Constant.CLOSE);
			roulletteRepository.save(optional.get());
			return new ReplyDTO(200, "ruleta cerrada", null);	
		}
		
		return new ReplyDTO(500, "ruleta no existe", null);			
	}
	
	private int winNumber() {
		return (int) (Math.random() * 36 + 1);
	}
	private String winColor(int number) {
		return number % 2 == 0 ? Constant.RED : Constant.BLACK;
	}
	
	private List<BetFinalDTO> calculatePrize(Long id_roullette,int number) {
		String color=winColor(number);
		List<Bet> listbet = betRepository.findByIdroullette(id_roullette);
		List<BetFinalDTO> listFinalDto = new ArrayList<>();
		for (Bet bet : listbet) {
			ModelMapper modelMapper = new ModelMapper();
			BetFinalDTO betfinal = modelMapper.map(bet, BetFinalDTO.class);
			if (Constant.NUMBER.equals(bet.getBet_type())
					&& bet.getNumber_option().compareTo(new BigDecimal(number)) == 0) {
				betfinal.setWin_value(betfinal.getBet_value().multiply(new BigDecimal(5)));
			}
			if (Constant.COLOR.equals(bet.getBet_type()) && color.equals(bet.getColor_option())) {
				betfinal.setWin_value(
						betfinal.getBet_value().multiply(new BigDecimal(1.8)).setScale(0, RoundingMode.DOWN));
			}
			listFinalDto.add(betfinal);
		}
		
		return listFinalDto;
	}
	
	@Override
	public ReplyDTO closeRoullette(Long id_roullette) {
		ReplyDTO replyDTO = close(id_roullette);
		if(replyDTO.getStatus()==200) {		
			int number=winNumber();
			List<BetFinalDTO> listfinal = calculatePrize(id_roullette,number);
			return new ReplyDTO(200, "ruleta cerrada. Numero ganador  " + winNumber(), listfinal);
		}else {
			return new ReplyDTO(500, "ruleta cerrada previamente o no existe", null);	
		}
	}

	@Override
	public List<RoulletteDTO> roulleteListing() {
		ModelMapper modelMapper = new ModelMapper();
		List<Roullette> listRoullette = (List<Roullette>) roulletteRepository.findAll();
		List<RoulletteDTO> postDtoList = Arrays.asList(modelMapper.map(listRoullette, RoulletteDTO[].class));
		return postDtoList;
	}

}
