package com.event;

public class SavingsAccount extends BankAccount{
	
	SavingsAccount(int accNum, String accHolder, double accBalance){
		super(accNum,accHolder,accBalance);
	}
	
	@Override
	public double withdraw(double amount) {
		if (amount>30000)
			throw new IllegalArgumentException("You can't withdraw more than 30000");
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
		if (amount>1000000)
			throw new IllegalArgumentException("You can't deposit more than 1000000");
		else {
			this.setAccBalance(this.getAccBalance()+amount);
			System.out.println("Transaction successful");
		}
		return this.getAccBalance();
	}
}
