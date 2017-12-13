/**
 * 
 */
package com.r2m.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private UUID userId;
	private Instant betDate;
	private Double betQuantity;
	private Double prizeAmount;
	private String[] resultCombo;
	private Boolean win;
	
	public Bet() {
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Instant getBetDate() {
		return betDate;
	}

	public void setBetDate(Instant betDate) {
		this.betDate = betDate;
	}

	public Double getBetQuantity() {
		return betQuantity;
	}

	public void setBetQuantity(Double betQuantity) {
		this.betQuantity = betQuantity;
	}

	public Double getPrizeAmount() {
		return prizeAmount;
	}

	public void setPrizeAmount(Double prizeAmount) {
		this.prizeAmount = prizeAmount;
	}

	public String[] getResultCombo() {
		return resultCombo;
	}

	public void setResultCombo(String[] resultCombo) {
		this.resultCombo = resultCombo;
	}

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}

}
