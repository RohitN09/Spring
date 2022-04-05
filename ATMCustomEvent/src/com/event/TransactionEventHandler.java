package com.event;

import java.util.Date;

import org.springframework.context.ApplicationListener;

public class TransactionEventHandler implements ApplicationListener<WithdrawalEvent>{
	private void sendSMS(String message) {
		System.out.println(message);
	}
		
	@Override
	public void onApplicationEvent(WithdrawalEvent event) {
		sendSMS(event.toString());
	}
}