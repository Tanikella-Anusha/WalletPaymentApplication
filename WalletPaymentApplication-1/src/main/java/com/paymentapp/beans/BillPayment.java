package com.paymentapp.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.paymentapp.beans.BillType;
import com.paymentapp.beans.Wallet;

@Entity

public class BillPayment {
	@Id
	@GeneratedValue
	private int billId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	@Enumerated(EnumType.STRING)
	private BillType billtype;
	private double amount;
//	@CreationTimestamp
	private LocalDate paymentDate;

	public BillPayment() {
		super();
	}
	
	public int getBillId() {
		return billId;
	}
	
	

	public void setBillId(int billId) {
		this.billId = billId;
	}
	
	
	  public Wallet getWallet()
	  { 
		  return wallet; 
	  } 
	  
	  public void setWallet(Wallet wallet)
    { 
		  this.wallet = wallet;
    }
	  
	  public BillType getBilltype() 
	  {
		  return billtype; 
	  }
	  public void setBilltype(BillType billtype)
	 { 
		  this.billtype = billtype;
	 }
	 
	
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "BillPayment [billId=" + billId + ", wallet=" + wallet + ", billtype=" + billtype + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + "]";
	}

}
