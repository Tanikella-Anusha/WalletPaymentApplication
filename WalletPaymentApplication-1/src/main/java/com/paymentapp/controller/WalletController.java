package com.paymentapp.controller;

import java.math.BigDecimal;
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

import com.paymentapp.service.WalletService;
import com.paymentapp.service.WalletServiceImpl;
import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.exception.InsufficientBalanceException;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.exception.MobileNumberNotRegistered;

@RestController
@RequestMapping(path="/api")
public class WalletController {
	@Autowired
	WalletServiceImpl walletservice;
	@Autowired
	WalletService wi;

	@RequestMapping("/hello")
	public String HelloWallet()
	{
		String msg="Welcome to payment wallet";
		return msg;
	}
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		Customer c=walletservice.addCustomer(customer);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getCustomers()
	{
		List<Customer> lc1=walletservice.getCustomers();
		ResponseEntity re=new ResponseEntity<List<Customer>>(lc1,HttpStatus.OK);
		return re;
	}
	@GetMapping("/getCustomerbymobileNo/{mobileNo}")
	public ResponseEntity<Customer> getCustomerBymobileNo(@PathVariable String mobileNo) throws InvalidInputException 
	{
		Customer c=walletservice.getCustomerBymobileNo(mobileNo);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@GetMapping(path = "/showBalance/{mobileNo}")
	public ResponseEntity<Customer> showBalance(@PathVariable String mobileNo) throws MobileNumberNotRegistered, InvalidInputException  {
		
		Customer c=wi.showBalance(mobileNo);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@PutMapping(path = "/makeDeposit/{mobileNo}/{amount}")
	public ResponseEntity<Customer>depositAmount(@PathVariable String mobileNo,@PathVariable BigDecimal amount) throws MobileNumberNotRegistered, InvalidInputException  {
		
		Customer c=wi.depositAmount(mobileNo, amount);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@PutMapping(path = "/withdrawMoney/{mobileNo}/{amount}")
	public ResponseEntity<Customer>withdrawMoney(@PathVariable String mobileNo,@PathVariable BigDecimal amount) throws MobileNumberNotRegistered, InvalidInputException, InsufficientBalanceException  {
		
		Customer c=wi.withdrawAmount(mobileNo, amount);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@PutMapping(path = "/transferMoney/{sourceMobileNo}/{targetMobileNo}/{amount}")
	public ResponseEntity<Customer>fundTransfer(@PathVariable String sourceMobileNo,@PathVariable String targetMobileNo,@PathVariable BigDecimal amount) throws MobileNumberNotRegistered, InvalidInputException, InsufficientBalanceException  {
		
		Customer c=wi.fundTransfer(sourceMobileNo, targetMobileNo,amount);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@PostMapping(path = "/createAccount/{cid}/{name}/{mobileNo}/{password}/{walletId}/{amount}")
	public ResponseEntity<Customer>newaccount(@PathVariable int cid,@PathVariable String name,@PathVariable String mobileNo,@PathVariable String password,@PathVariable int walletId,@PathVariable BigDecimal amount) throws MobileNumberNotRegistered, InvalidInputException, InsufficientBalanceException  {
		
		Customer c=wi.createAccount(cid,name, mobileNo, password,walletId,amount);
		ResponseEntity re=new ResponseEntity<Customer>(c,HttpStatus.OK);
		return re;
	}
	@PutMapping(path = "/updateAccount")
	public String updateOrder(@RequestBody Customer customer) throws InvalidInputException {
		Customer c1 =wi.updateAccount(customer);
		return "User Updated Successfully" + c1;
	}
	@DeleteMapping(path="/deleteCustomer/{cid}")
	public ResponseEntity<String>deleteCustomerById(@PathVariable int cid)
	{
		walletservice.deleteCustomerById(cid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
