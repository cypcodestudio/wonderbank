package com.lekodevs.wonderbank.entity.dto;

public class AccountCreateRequestDTO {

	private String entityNo;
	private double amount;
	private String account;
	
	/**
	 * @return the entityNo
	 */
	public String getEntityNo() {
		return entityNo;
	}
	/**
	 * @param entityNo the entityNo to set
	 */
	public void setEntityNo(String entityNo) {
		this.entityNo = entityNo;
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
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
