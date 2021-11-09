package com.paymentapp.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.exception.InsufficientBalanceException;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.exception.MobileNumberNotRegistered;
import com.paymentapp.repo.WalletRepo;

@Service
public class WalletServiceImpl implements  WalletService{
	
	@Autowired
	 private WalletRepo repo;
	
	
	
	public Customer getCustomerBymobileNo(String mobileNo) throws InvalidInputException
	{
		if(mobileNo.length()==10) {
		Customer c=repo.findCustomer(mobileNo);
		return c;
		}
		else
			throw new InvalidInputException("Mobile No. Not Registered");
		
	}
	
	public Customer addCustomer(Customer c)
	{
		 repo.save(c);	
		 return c;
	}

	public String deleteCustomerById(int cid) {
		
		repo.deleteById(cid);
		
		return "Deleted";
	}
	public List<Customer> getCustomers()
	{
		List<Customer> lc1=repo.findAll();
		
		return lc1;
	}


	@Override
	public Customer showBalance(String mobileNo) throws MobileNumberNotRegistered, InvalidInputException {
		Pattern p=Pattern.compile("[0-9]{10}");
		Matcher m=p.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{	
		               Customer customer=null;
			         customer = repo.findCustomer(mobileNo);
		                   if(customer!=null)
			                 return customer;
		                    else
		                	throw new MobileNumberNotRegistered("your mobile number not registered");
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered
	{
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			
			throw new InvalidInputException("You cannot deposit Zero balance in your account");
			
		} 
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException(" deposited amount caanot be negative or zero");
			
		} 
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{
		Customer cust1=null;
		
			cust1=repo.findCustomer(mobileNo);
		
		 if(cust1==null)
		    
		    	throw new MobileNumberNotRegistered(" mobile Number is not registered");
		 else
		 {
		BigDecimal p1=cust1.getWallet().getBalance();
		int i1=cust1.getWallet().getWalletId();
		p1=p1.add(amount);
		Wallet ob=new Wallet(i1,p1);
		cust1.setWallet(ob);
		
		repo.save(cust1);
		return cust1;
		 }
		}
		else
		{
			
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}	
	}
	
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException 
	{	if(amount.compareTo(new BigDecimal("0.00")) ==0)
			throw new InvalidInputException ("You cannot withdraw Zero balance in your account");
		if(amount.compareTo(new BigDecimal("0.00")) <=0)
			throw new InvalidInputException("withdrawl amount caanot be negative ror zero");
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{
		     Customer cust1=null;
			cust1=repo.findCustomer(mobileNo);
		      if(cust1==null)
		    	throw new MobileNumberNotRegistered("mobile Number is not registered");
		     else
		    {
		      BigDecimal p1=cust1.getWallet().getBalance();
		  	int i1=cust1.getWallet().getWalletId();
		        p1=p1.subtract(amount);
		      if(p1.compareTo(new BigDecimal("0.00")) <0)
			  throw new InsufficientBalanceException("Insufficient balance in source registered mobile number");
		     Wallet ob=new Wallet(i1,p1);
		      cust1.setWallet(ob);
		     repo.save(cust1);
		return cust1;
		 }
		}
		else
		throw new InvalidInputException("please correctly enter 10 digit mobile number");
}	
	
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException 
	{
		
		if(amount.compareTo(new BigDecimal("0.00")) ==0)
		{
			
			throw new InvalidInputException("You cannot transfer Zero balance");
			
		} 
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException("amount caanot be negative");
			
		} 
		Pattern pattern=Pattern.compile("[0-9]{10}");
		Matcher m=pattern.matcher(sourceMobileNo);
		Matcher m1=pattern.matcher(targetMobileNo);
		if(m.find()&& m.group().equals(sourceMobileNo) &&  m1.find()&& m1.group().equals(targetMobileNo))
		{
		   Customer cust1=null;
		    Customer cust2=null;
			cust1=repo.findCustomer(sourceMobileNo);
			 cust2=repo.findCustomer(targetMobileNo);
	                 if(cust1==null && cust2==null)
	             	throw new MobileNumberNotRegistered("Source mobile Number and target mobile number is not registered");
	              else if(cust2==null)
	    	   throw new MobileNumberNotRegistered("Target mobile Number is not registered");
	              else if(cust1==null)
	    	     throw new MobileNumberNotRegistered("Source mobile Number is not registered");
	    
	              else
	                {
	    	          if(sourceMobileNo.equals(targetMobileNo))
			           {
			throw new InvalidInputException("Source mobile number and target mobile number cannot be same");
			             }
		    BigDecimal p=cust1.getWallet().getBalance();
			int i1=cust1.getWallet().getWalletId();
		   p=p.subtract(amount);
		if(p.compareTo(new BigDecimal("0.00")) <0)
		{
			throw new InsufficientBalanceException("Insufficient balance in source registered mobile number");
		}
		Wallet ob=new Wallet(i1,p);
		cust1.setWallet(ob);
		BigDecimal q=cust2.getWallet().getBalance();
		int i2=cust2.getWallet().getWalletId();
		q=q.add(amount);
				Wallet ob1=new Wallet(i2,q);
		cust2.setWallet(ob1);
          
			repo.save(cust1);
			repo.save(cust2);
	
         return cust1;
	    }
    }
	else
	{
		throw new InvalidInputException("please correctly enter 10 digit mobile number");
	}
	}

	public Customer createAccount(int cid,String name,String mobileNo,String password,int walletId,BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered
	{
		
		if(amount.compareTo(new BigDecimal("0.00")) <0)
		{
			
			throw new InvalidInputException("amount cannot be negative");
			
		}
		Pattern p=Pattern.compile("[0-9]{10}");
		Matcher m=p.matcher(mobileNo);
		if(m.find()&& m.group().equals(mobileNo))
		{		
		         Customer c1=null;
		         c1=repo.findCustomer(mobileNo);
			     
		         if(c1==null)
		              {
		              Wallet ob=new Wallet(walletId,amount);
	                  Customer customer=new Customer(cid,name,mobileNo,password,ob);
			            c1=customer;
				        repo.save(customer);
		                  return c1;
		              }
		                else
		                    {
			
			
			                    throw new MobileNumberNotRegistered("your mobile number already registered");
		                         }
		}
		else
		{
			throw new InvalidInputException("please correctly enter 10 digit mobile number");
		}
		}
	@Override
	 public Customer updateAccount(Customer customer)throws InvalidInputException {
		
		
		Customer c=repo.findById(customer.getCid()).orElseThrow();
		if(customer.getMobileNo()!=null) {
			c.setMobileNo(customer.getMobileNo());
		}
		if(customer.getName()!=null) {
			c.setName(customer.getName());
		}
		if(customer.getPassword()!=null) {
			c.setPassword(customer.getPassword());
		}
		
		
		return repo.save(c);
		
		
		
	
	
	}

}