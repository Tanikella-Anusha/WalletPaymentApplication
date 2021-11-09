package com.paymentapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.service.IAccountService;
import com.paymentapp.service.IAccountServiceImpl;



@RestController
public class BankAccountController 
{
	@Autowired
	IAccountServiceImpl iaccountservice;
	
	@RequestMapping("/Hello")
	public String HelloWallet()
	{
		String msg="welcome to wallet application";
		return msg;
	}
	 @PostMapping("/addaccount") 
	  public  ResponseEntity<BankAccount> addAccount(@RequestBody BankAccount bacc) 
	  {
		 
		  BankAccount ba=iaccountservice.addAccount(bacc);
		  ResponseEntity re=new ResponseEntity<BankAccount>(ba,HttpStatus.OK);
		  return re;
	  }
	  @GetMapping("/viewallaccounts")
	  public List<BankAccount> viewAccount()
	  {
		 
		  List<BankAccount> ba=iaccountservice.viewAllAccounts(); 
		  return ba;
	}
	  
	  @DeleteMapping("/removeaccount/{accid}")
	  public ResponseEntity<Wallet> removeAccount(@PathVariable BankAccount accid)
		{
		  iaccountservice.removeAccount(accid);
			
			ResponseEntity re=new ResponseEntity<Wallet>(HttpStatus.OK);
			return re;
		}
	    @GetMapping("/viewaccount/{accountNo}") 
		 public ResponseEntity<BankAccount> viewAccount(@PathVariable int accountNo) throws Throwable
		  {
			  BankAccount w1=iaccountservice.getAccountById(accountNo);
			  ResponseEntity re=new ResponseEntity<BankAccount>(w1,HttpStatus.OK); 
			  return re; 
		  }
		 
}
