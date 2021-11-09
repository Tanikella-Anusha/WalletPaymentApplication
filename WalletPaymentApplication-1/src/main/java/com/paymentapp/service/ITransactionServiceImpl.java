package com.paymentapp.service;

import java.sql.Date;
import java.time.LocalDate;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentapp.beans.Transaction;
import com.paymentapp.beans.Wallet;
import com.paymentapp.repo.ITransactionRepository;


@Service
public class ITransactionServiceImpl implements ITransactionService{
	
	@Autowired
	ITransactionRepository itrp;
	
	
	@Override
	public List<Transaction>addTransaction(Transaction tran)
	{ 
		// TODO Auto-generated method stub
		itrp.save(tran);
		return itrp.findAll();
	}
	  @Override 
	  public List<Transaction> viewAllTransactions()
	  { 
		  return  itrp.findAll();
	  }
	
	   @Override 
	   public List<Transaction> viewTransactionsByDate(Date from,Date to)
	   { 
		   
		   itrp.viewTransactionByDate(from, to);
		   return itrp.findAll();
	   }
	
//	  
		/*
		 * @Override public List<Transaction> viewTransaction() {
		 * 
		 * return itrp.findAll(); }
		 */
			 
	  
	  
/*
	
	 * 
	 * @Override public List<Transaction> viewTransactionsByDate(LocalDate from,
	 * LocalDate to) { // TODO Auto-generated method stub itrp.findAll(); return
	 * itrp.viewTransactionByDate(from, to); }
	 */
	   public Transaction viewByTransactionType(String transactionType) {
		   
		   Transaction t=itrp.viewTransaction(transactionType);
		   return t;

	   }
	 
	   
}
