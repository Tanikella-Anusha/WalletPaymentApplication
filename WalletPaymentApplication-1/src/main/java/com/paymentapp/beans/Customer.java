package com.paymentapp.beans;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int cid;
private String name;
@Column(length = 10)
private String mobileNo;
private String password;
@OneToOne(cascade = CascadeType.MERGE)
private Wallet wallet;


public Customer() {
	super();
}






public Customer(int cid, String name, String mobileNo, String password, Wallet wallet) {
	super();
	this.cid = cid;
	this.name = name;
	this.mobileNo = mobileNo;
	this.password = password;
	this.wallet = wallet;
}






public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Wallet getWallet() {
	return wallet;
}
public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}

@Override
public String toString() {
	return "Customer [cid=" + cid + ", name=" + name + ", mobileNo=" + mobileNo + ", password=" + password + ", wallet="
			+ wallet + "]";
}


	
}

