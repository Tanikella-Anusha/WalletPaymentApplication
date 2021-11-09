package com.paymentapp.service;
import java.util.List;

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.Wallet;

public interface IAccountService 
{

	
	//public List<Wallet> addAccount(BankAccount bacc);
	//public Wallet removeAccount(BankAccount bacc);
	//public Wallet viewAccount(BankAccount bacc);
	public List<BankAccount> viewAllAccounts();

	
}
