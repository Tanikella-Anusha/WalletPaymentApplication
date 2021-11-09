package com.paymentapp.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paymentapp.beans.BillPayment;


public interface IBillPaymentService {
	
	public BillPayment addBillPayment(BillPayment payment);
	public List<BillPayment> viewBillPayment();

}