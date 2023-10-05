package com.lekodevs.wonderbank.entity.dto;

public class TransferRequestDTO {
	
	private String fromAccount;
	private String toAccount;
	private double amount;
	/**
	 * @return the fromAccount
	 */
	public String getFromAccount() {
		return fromAccount;
	}
	/**
	 * @param fromAccount the fromAccount to set
	 */
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	/**
	 * @return the toAccount
	 */
	public String getToAccount() {
		return toAccount;
	}
	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
