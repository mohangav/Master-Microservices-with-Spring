package com.eazytbytes.accounts.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Accounts {

	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="account_number")
	@Id
	private long accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="branch_address")
	private String branchName;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public LocalDate getLocatDt() {
		return locatDt;
	}

	public void setLocatDt(LocalDate locatDt) {
		this.locatDt = locatDt;
	}

	@Column(name="create_dt")
	private LocalDate locatDt;
}
