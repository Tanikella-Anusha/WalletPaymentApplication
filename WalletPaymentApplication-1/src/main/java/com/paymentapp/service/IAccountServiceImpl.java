package com.paymentapp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.repo.IAccountRepository;
import com.paymentapp.repo.WalletRepo;

@Service
public class IAccountServiceImpl implements IAccountService
{
	
	  @Autowired 
	  IAccountRepository accrepo;
	  
	  @Autowired
	  WalletRepo wrepo;
	  
	  
	  public BankAccount addAccount(BankAccount bacc) 
	  { 
		  accrepo.save(bacc);
		  return bacc; 
	  }
	  @Override
	  public List<BankAccount> viewAllAccounts()
	  {
		  return accrepo.findAll();
	  }
	  public Wallet removeAccount(BankAccount accid)
	  {
		 
		  accrepo.delete(accid);
		  return null;
	  }
	  
	 public BankAccount getAccountById(int accountNo) throws Throwable
	 
	  {
		 Supplier s=()->new InvalidInputException("Account Does not exist");
		    BankAccount b=accrepo.findById(accountNo).orElseThrow(s);
		    return b;
		    
	  }
	 /*
	 * @Override public Wallet removeAccount(BankAccount bacc) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Wallet viewAccount(BankAccount bacc) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public List<Wallet> viewAllAccounts(Wallet wallet) { // TODO
	 * Auto-generated method stub return null; }
	 */
	
}
