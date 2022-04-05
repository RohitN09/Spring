package com.event;

import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {
	double accBalance;

	public WithdrawalEvent(Object source, double accBalance) {
		super(source);
		this.accBalance = accBalance;
	}

	@Override
	public String toString() {
		return "money has been withdrawn from your account\n" + "Remaining acc Balance: " + this.accBalance
				+ "\nTimestamp: "+new Date();
	}

}