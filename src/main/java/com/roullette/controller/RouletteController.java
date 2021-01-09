package com.roullette.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roullette.dto.BetDTO;
import com.roullette.dto.ReplyDTO;
import com.roullette.dto.RoulletteDTO;
import com.roullette.services.BetServiceI;
import com.roullette.services.RoulletteServiceI;

@RestController
@RequestMapping("/roulette")
public class RouletteController {
	@Autowired
	private RoulletteServiceI roulletteServiceI;
	@Autowired
	private BetServiceI betServiceI;

	@PostMapping("/create")
	public ResponseEntity<Long> createRoullette(@RequestBody RoulletteDTO roulletteDTO) {
		try {
			return ResponseEntity.ok(roulletteServiceI.createRoullette(roulletteDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/open")
	public ResponseEntity<String> openRoullet(@RequestParam Long id_roullette) {
		try {
			return ResponseEntity.ok(roulletteServiceI.openRoullette(id_roullette));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/bet")
	public ResponseEntity<String> createBet(@RequestHeader Long idUser, @RequestBody BetDTO betDto) {
		try {
			return ResponseEntity.ok(betServiceI.createBet(idUser, betDto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/close")
	public ResponseEntity<ReplyDTO> closeRoullette(@RequestParam Long id_roullette) {
		try {
			return ResponseEntity.ok(roulletteServiceI.closeRoullette(id_roullette));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/list")
	public ResponseEntity<List<RoulletteDTO>> roulleteListing() {
		try {
			return ResponseEntity.ok(roulletteServiceI.roulleteListing());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
