package com.bank.model;

import java.sql.Timestamp;

public class Transactions {
	private String transactionNo;
	private long accountNo;
	private Timestamp dateAndTime;
	private String transactionType;
	private double amount;
	private double balanceAfterTransaction;
	
	public String getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public Timestamp getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
}	
