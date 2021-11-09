package com.paymentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapp.beans.BillPayment;
import com.paymentapp.service.IBillPaymentServiceImp;

@RestController
@RequestMapping(path="/api")
public class BillPaymentController {
	
	@Autowired
	IBillPaymentServiceImp billpay;
	
	
	@PostMapping("/addBillPayment")
	public ResponseEntity<BillPayment> addBillPayment(@RequestBody BillPayment payment)
	{
		BillPayment p1=billpay.addBillPayment(payment);
		ResponseEntity re=new ResponseEntity<BillPayment>(p1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewBillPayment")
	public ResponseEntity<List<BillPayment>> viewBillPayment()
	{
		List<BillPayment> l1=billpay.viewBillPayment();
		ResponseEntity re=new ResponseEntity<List<BillPayment>> (l1,HttpStatus.OK);
		return re;
	}

}

