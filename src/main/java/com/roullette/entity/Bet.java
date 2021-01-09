package com.roullette.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
@RedisHash("Bet")
public class Bet {
	@Id
	private Long id_bet;
	private String bet_type;
	private BigDecimal bet_value;
	private String color_option;
	private BigDecimal number_option;
	private Long id_user;
	@Indexed
	private Long idroullette;

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

	public Long getIdroullette() {
		return idroullette;
	}

	public void setIdroullette(Long idroullette) {
		this.idroullette = idroullette;
	}

}
