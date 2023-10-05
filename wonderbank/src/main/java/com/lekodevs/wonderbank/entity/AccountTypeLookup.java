package com.lekodevs.wonderbank.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "AccountTypeLookup")
public class AccountTypeLookup implements Serializable{
private static final long serialVersionUID = 5926468583005150707L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "min_balance", nullable = false)
	private double minimumBalance;
	
	@Column(name = "min_overdraft_balance", nullable = false)
	private double minimumOverdraftBalance;
	
	@Column(name = "max_overdraft_balance", nullable = false)
	private double maximumOverdraftBalance;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the minimumBalance
	 */
	public double getMinimumBalance() {
		return minimumBalance;
	}

	/**
	 * @param minimumBalance the minimumBalance to set
	 */
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	/**
	 * @return the minimumOverdraftBalance
	 */
	public double getMinimumOverdraftBalance() {
		return minimumOverdraftBalance;
	}

	/**
	 * @param minimumOverdraftBalance the minimumOverdraftBalance to set
	 */
	public void setMinimumOverdraftBalance(double minimumOverdraftBalance) {
		this.minimumOverdraftBalance = minimumOverdraftBalance;
	}

	/**
	 * @return the maximumOverdraftBalance
	 */
	public double getMaximumOverdraftBalance() {
		return maximumOverdraftBalance;
	}

	/**
	 * @param maximumOverdraftBalance the maximumOverdraftBalance to set
	 */
	public void setMaximumOverdraftBalance(double maximumOverdraftBalance) {
		this.maximumOverdraftBalance = maximumOverdraftBalance;
	}
	
	
}
