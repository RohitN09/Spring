package com.springboot.my.org.crudapi.model;

import java.sql.Date;

public class Bonus {
	private int workerRefId, bonusAmount;
	private Date bonusDate;
	
	public Bonus() {
		this.bonusDate = new Date(System.currentTimeMillis());
	}
	
	public Bonus(int workerRefId, int bonusAmount, Date bonusDate) {
		this.workerRefId = workerRefId;
		this.bonusAmount = bonusAmount;
		this.bonusDate = bonusDate;
	}

	public int getWorkerRefId() {
		return workerRefId;
	}

	public void setWorkerRefId(int workerRefId) {
		this.workerRefId = workerRefId;
	}

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Date getBonusDate() {
		return bonusDate;
	}

	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}

	@Override
	public String toString() {
		return "Bonus [workerRefId=" + workerRefId + ", bonusAmount=" + bonusAmount + ", bonusDate=" + bonusDate + "]";
	}
}