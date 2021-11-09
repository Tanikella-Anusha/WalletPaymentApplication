package com.paymentapp.beans;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="wallet")
public class Wallet {
	
	@Id
	
	private int walletId;
	private BigDecimal balance;
	
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "wallet")
	private BankAccount bankaccount;
	
	
	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}


	public Wallet(int walletId, BigDecimal balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}


	public Wallet() {
		super();
	}


	public int getWalletId() {
		return walletId;
	}
	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", balance=" + balance + "]";
	}
	
	

}
