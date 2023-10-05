package com.lekodevs.wonderbank.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBalanceResponseDTO {
	private String account;
	private double balance;
	private Double overdraft;
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
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the overdraft
	 */
	public Double getOverdraft() {
		return overdraft;
	}
	/**
	 * @param overdraft the overdraft to set
	 */
	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}
	
	

}
