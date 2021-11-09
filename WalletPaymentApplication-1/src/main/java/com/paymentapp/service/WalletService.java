package com.paymentapp.service;
import java.math.BigDecimal;

import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.exception.InsufficientBalanceException;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.exception.MobileNumberNotRegistered;

public interface WalletService {
public Customer createAccount(int cid,String name, String mobileno,String password,int walletId,BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered;
    public Customer showBalance (String mobileNo) throws MobileNumberNotRegistered, InvalidInputException;
   public Customer depositAmount (String mobileNo,BigDecimal amount ) throws InvalidInputException, MobileNumberNotRegistered;
    public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException;
  public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount) throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException;
    public Customer updateAccount(Customer customer) throws InvalidInputException;


}
