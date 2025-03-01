package com.plant_care_2025.model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "account")
public class Account {
	@Id
	@Column(name = "accountNumber", nullable = false, unique = true) //Primary key for the Account Table
	private String accountNumber;
	
	@Column(name = "accountType", nullable = false)
	private String accountType;
	
	@Column(name = "balance", nullable = false)
	private double balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
