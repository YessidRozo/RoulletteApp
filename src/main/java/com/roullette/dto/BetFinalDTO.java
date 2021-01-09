package com.roullette.dto;

import java.math.BigDecimal;

public class BetFinalDTO {
	
	private Long id_bet;
	private String bet_type;
	private BigDecimal bet_value;
	private String color_option;
	private BigDecimal number_option;
	private Long id_user;
	private Long id_roullette;
	private BigDecimal win_value;
	

	public Long getId_bet() {
		return id_bet;
	}

	public void setId_bet(Long id_bet) {
		this.id_bet = id_bet;
	}

	public String getBet_type() {
		return bet_type;
	}

	public void setBet_type(String bet_type) {
		this.bet_type = bet_type;
	}

	public BigDecimal getBet_value() {
		return bet_value;
	}

	public void setBet_value(BigDecimal bet_value) {
		this.bet_value = bet_value;
	}

	public String getColor_option() {
		return color_option;
	}

	public void setColor_option(String color_option) {
		this.color_option = color_option;
	}

	public BigDecimal getNumber_option() {
		return number_option;
	}

	public void setNumber_option(BigDecimal number_option) {
		this.number_option = number_option;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_roullette() {
		return id_roullette;
	}

	public void setId_roullette(Long id_roullette) {
		this.id_roullette = id_roullette;
	}

	public BigDecimal getWin_value() {
		return win_value;
	}

	public void setWin_value(BigDecimal win_value) {
		this.win_value = win_value;
	}

}
