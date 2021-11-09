package com.paymentapp.service;

import java.util.List;

import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.beans.Customer;

public interface IBenificiaryService {
	public BenificiaryDetails addBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws Throwable;
	public String deleteBenificiary(BenificiaryDetails bd);
	public BenificiaryDetails viewBenificiary(String mobileNumber);
	public List<BenificiaryDetails> viewAllBenificiary();
	

}
