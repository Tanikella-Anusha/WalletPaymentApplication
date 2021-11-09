package com.paymentapp.controller;
import java.sql.Date;
import java.time.LocalDate;
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

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.Transaction;
import com.paymentapp.beans.Wallet;
import com.paymentapp.service.ITransactionServiceImpl;

@RestController
@RequestMapping(path="/api")
public class TranscationController {
	
	@Autowired
	ITransactionServiceImpl itrs;
	
	  @PostMapping("/addTrans")
	  public List<Transaction> addTrans(@RequestBody Transaction tran)
	  {
		  List<Transaction>bac=itrs.addTransaction(tran);
		  
		  return bac;
	  }	
	  
	  @GetMapping("/showTrans")
	  public List<Transaction> showAll()
	  {
		  List<Transaction> at=itrs.viewAllTransactions();
		  return at;
			
	  }
	  
	  @GetMapping("/getTrans/{from}/{to}")
	  public List<Transaction>viewTransactions(@PathVariable Date from,@PathVariable Date to)
	  {
		  List<Transaction>lt=itrs.viewTransactionsByDate(from, to);
	  return lt;
	  }
		
	  
	  @GetMapping("/getTransactionByType/{transactionType}")
	    public ResponseEntity<Transaction> getTransaction(@PathVariable String transactionType) 
	    {
	        Transaction t=itrs.viewByTransactionType(transactionType);
	        ResponseEntity re=new ResponseEntity<Transaction>(t,HttpStatus.OK);
	        return re;
	    }
}

