package com.paymentapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name=" BenificiaryDetails")
public class BenificiaryDetails {
	@Id
	@GeneratedValue
	
	private int benificiaryId;
	private String name;
	@Size(min=10,max=10)
	@NotNull
	@Pattern(regexp="^$|[0-9]{10}")
	private String mobileNumber;
	
	public BenificiaryDetails() {
		super();
	}
	public int getBenificiaryId() {
		return benificiaryId;
	}
	public void setBenificiaryId(int benificiaryId) {
		this.benificiaryId = benificiaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "BenificiaryDetails [benificiaryId=" + benificiaryId + ", name=" + name + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	

}
