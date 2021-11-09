package com.paymentapp.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.paymentapp.beans.Transaction;
import com.paymentapp.beans.Wallet;

public interface ITransactionService {
	
	
	
	 public List<Transaction> addTransaction(Transaction tran); 
	
	 public List<Transaction> viewAllTransactions(); 
   public List<Transaction>viewTransactionsByDate(Date from,Date to); 
//	 public List<Transaction> viewTransaction();
	 
	 
}

