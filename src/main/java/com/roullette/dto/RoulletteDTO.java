package com.roullette.dto;

import java.math.BigDecimal;

public class RoulletteDTO {
	private Long id_roullette;
	private String name_roullette;
	private String state;
	private BigDecimal maximum_bet;

	public Long getId_roullette() {
		return id_roullette;
	}

	public void setId_roullette(Long id_roullette) {
		this.id_roullette = id_roullette;
	}

	public String getName_roullette() {
		return name_roullette;
	}

	public void setName_roullette(String name_roullette) {
		this.name_roullette = name_roullette;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getMaximum_bet() {
		return maximum_bet;
	}

	public void setMaximum_bet(BigDecimal maximum_bet) {
		this.maximum_bet = maximum_bet;
	}

}
