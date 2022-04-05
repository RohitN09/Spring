package com.event;

public class SalaryAccount extends BankAccount{
	
	SalaryAccount(int accNum, String accHolder, double accBalance){
		super(accNum,accHolder,accBalance);
	}
	
	@Override
	public double withdraw(double amount) {
		if (amount>100000)
			throw new IllegalArgumentException("You can't withdraw more than 100000");
		else if (amount>this.getAccBalance())
			throw new IllegalArgumentException("Insufficient Balance");
		else {
			this.setAccBalance(this.getAccBalance()-amount);
			System.out.println("Transaction Successful!");
		}
		return this.getAccBalance();
	}
	
	@Override
	public double deposit(double amount) {
		this.setAccBalance(this.getAccBalance()+amount);
		System.out.println("Transaction successful");
		return this.getAccBalance();
	}
}