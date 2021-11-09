package com.paymentapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.beans.Customer;
import com.paymentapp.service.IBenificiaryServiceImp;

@RestController
@RequestMapping(path="/api")
public class BenificiaryDetailsController {
	
	@Autowired
	IBenificiaryServiceImp ibenificiary;
	
	@PostMapping("/addBenificiary")
	public ResponseEntity<BenificiaryDetails> addBenificiary(@RequestBody BenificiaryDetails bd) {
		BenificiaryDetails bd1=ibenificiary.addBenificiary(bd);
		ResponseEntity re=new ResponseEntity<BenificiaryDetails>(bd1,HttpStatus.OK);
		return re;
	}
	@PutMapping("/updateBenificiary")
	public ResponseEntity<BenificiaryDetails> updateBenificiary(@RequestBody BenificiaryDetails bd) throws Throwable{
		BenificiaryDetails bd1=ibenificiary.updateBenificiary(bd);
		ResponseEntity re=new ResponseEntity<BenificiaryDetails>(bd1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deleteBenificiary")
	public ResponseEntity<String> deleteBenificiary(@RequestBody BenificiaryDetails bd)
	{
		ibenificiary.deleteBenificiary(bd);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewBenificiary/{mobileNumber}")
	public ResponseEntity <BenificiaryDetails> viewBenificiary(@PathVariable String mobileNumber)
	{
		BenificiaryDetails bd1=ibenificiary.viewBenificiary(mobileNumber);
		ResponseEntity re=new ResponseEntity<BenificiaryDetails>(bd1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/viewAllBenificiary")
	public ResponseEntity<List< BenificiaryDetails>> viewAllBenificiary()
	{
		List< BenificiaryDetails> l=ibenificiary.viewAllBenificiary();
		ResponseEntity re=new ResponseEntity<List< BenificiaryDetails>>(l,HttpStatus.OK);
		return re;
	}
}

