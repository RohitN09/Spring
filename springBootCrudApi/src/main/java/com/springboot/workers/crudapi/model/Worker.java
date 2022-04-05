package com.springboot.workers.crudapi.model;

import java.sql.Date;

public class Worker implements Comparable<Worker> {
    private int workerId;
    private String firstName;
    private String lastName;
    private int salary;
    private Date joiningDate;
    private String dept;
    private String email;

    public Worker() {
    	this.joiningDate = new Date(System.currentTimeMillis());
    }
    
    public Worker(int workerId, String firstName, String email) {
        this.workerId = workerId;
        this.firstName = firstName;
        this.email = email;
        this.joiningDate = new Date(System.currentTimeMillis());
    }

    public Worker(int workerID, String firstName, String lastName, int salary, String dept, String email) {
        this.workerId = workerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = new Date(System.currentTimeMillis());
        this.dept = dept;
        this.email = email;
    }
    
    public Worker(int workerID, String firstName, String lastName, int salary, Date joiningDate, String dept, String email) {
        this.workerId = workerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.dept = dept;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setJoiningDate() {
        this.joiningDate = new Date(System.currentTimeMillis());
    }
    
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    public Date getJoiningDate() {
        return joiningDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + workerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (email == null) {
            if (other.getEmail() != null)
                return false;
        } else if (!email.equals(other.getEmail()))
            return false;
        if (firstName == null) {
            if (other.getFirstName() != null)
                return false;
        } else if (!firstName.equals(other.getFirstName()))
            return false;
        if (workerId != other.getWorkerId())
            return false;
        return true;
    }

    @Override
    public int compareTo(Worker worker) {
        return this.workerId - worker.getWorkerId();
    }

    @Override
    public String toString() {
        return "Worker [dept=" + dept + ", email=" + email + ", firstName=" + firstName + ", joiningDate=" + joiningDate
                + ", lastName=" + lastName + ", salary=" + salary + ", workerId=" + workerId + "]";
    }
}