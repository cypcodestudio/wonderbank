package com.lekodevs.wonderbank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "WEntityAccount")
public class EntityAccount implements Serializable{
	private static final long serialVersionUID = 5926468583005150707L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_type_id", nullable = false)
	private AccountTypeLookup accountType;
	
	@ManyToOne
	@JoinColumn(name = "entity_id")
	private WEntity accountHolder;
	
	@Column(name = "balance")
	private double balance;
	
	@Column(name = "overdraft_balance")
	private double overDraftBalance;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the accountType
	 */
	public AccountTypeLookup getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountTypeLookup accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the accountHolder
	 */
	public WEntity getAccountHolder() {
		return accountHolder;
	}

	/**
	 * @param accountHolder the accountHolder to set
	 */
	public void setAccountHolder(WEntity accountHolder) {
		this.accountHolder = accountHolder;
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
	 * @return the overDraftBalance
	 */
	public double getOverDraftBalance() {
		return overDraftBalance;
	}

	/**
	 * @param overDraftBalance the overDraftBalance to set
	 */
	public void setOverDraftBalance(double overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}
	
	
	
}
