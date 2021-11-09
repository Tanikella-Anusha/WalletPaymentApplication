package com.paymentapp.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.beans.Customer;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.repo.IBenificiaryRepository;
@Service
public class IBenificiaryServiceImp implements IBenificiaryService {
	
	@Autowired
	IBenificiaryRepository repo;

	@Override
	public BenificiaryDetails addBenificiary(@RequestBody BenificiaryDetails bd) {
		repo.save(bd);
		return bd;
	}

	@Override
	public BenificiaryDetails updateBenificiary(BenificiaryDetails bd) throws Throwable {
		
		int id=bd.getBenificiaryId();
		Supplier s=()->new InvalidInputException("Person Does not exist");
	
		BenificiaryDetails bd1=repo.findById(id).orElseThrow(s);
		bd1.setName(bd.getName());
		bd1.setMobileNumber(bd.getMobileNumber());
		repo.save(bd1);
		
		return bd1;
	}

	@Override
	public String deleteBenificiary(BenificiaryDetails bd) {
		repo.delete(bd);
		
		return "Deleted";
	}

	@Override
	public BenificiaryDetails viewBenificiary(String mobileNumber) {
		BenificiaryDetails bd=repo.findByMobileNumber(mobileNumber);
		return bd;
	}

	@Override
	public List< BenificiaryDetails> viewAllBenificiary() {
		List<BenificiaryDetails> l=repo.findAll();
		return l;
	}

	
}

