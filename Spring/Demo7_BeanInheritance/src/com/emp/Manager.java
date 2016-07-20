package com.emp;

public class Manager extends Employee {
    int commission;

	
	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return (super.toString()+"Manager [commission=" + commission + "]");
	}
	
}
