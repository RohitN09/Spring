package com.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void publish(double accBalance) {
		WithdrawalEvent withdrawalEvent = new WithdrawalEvent(this, accBalance);
		publisher.publishEvent(withdrawalEvent);
	}
}