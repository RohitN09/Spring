package com.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		WithdrawalEventPublisher publisher = (WithdrawalEventPublisher) context.getBean("customEventPublisher");
		BankAccount acc1 = new SavingsAccount(101, "Rohit", 100000);
		double balance=acc1.withdraw(20000);
		publisher.publish(balance);
		double balance2=acc1.withdraw(30000);
		publisher.publish(balance2);
	}
}