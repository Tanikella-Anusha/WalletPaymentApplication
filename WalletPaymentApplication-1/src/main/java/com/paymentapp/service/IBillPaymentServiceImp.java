package com.paymentapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentapp.beans.BillPayment;
import com.paymentapp.repo.IBillPaymentRepository;
@Service
public class IBillPaymentServiceImp implements IBillPaymentService  {
	
	@Autowired
	IBillPaymentRepository repo;
	@Override
	public BillPayment addBillPayment(@RequestBody BillPayment payment) {
		repo.save(payment);
		
		return payment;
	}

	@Override
	public List<BillPayment> viewBillPayment() {
		
		List<BillPayment> l=repo.findAll();

		return l;
	}


	


}
