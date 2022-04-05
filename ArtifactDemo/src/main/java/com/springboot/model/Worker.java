package com.springboot.model;

public class Worker {
	int workerId;
	String workerName;
	double salary;
	
	public Worker(int workerId, String workerName, double salary){
		this.workerId = workerId;
		this.workerName = workerName;
		this.salary = salary;
	}

	public int getWorkerId() {
		return workerId;
	}

	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", workerName=" + workerName + ", salary=" + salary + "]";
	}
}
