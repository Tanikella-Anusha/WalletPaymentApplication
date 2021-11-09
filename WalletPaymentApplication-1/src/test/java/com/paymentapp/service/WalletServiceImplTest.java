package com.paymentapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
import com.paymentapp.exception.InsufficientBalanceException;
import com.paymentapp.exception.InvalidInputException;
import com.paymentapp.exception.MobileNumberNotRegistered;
import com.paymentapp.repo.WalletRepo;


@SpringBootTest
class WalletServiceImplTest {
	
	@Autowired
	WalletServiceImpl wsl;
	
	@MockBean
	WalletRepo wr;

	@Test
	void testGetCustomerBymobileNo() throws InvalidInputException 
	{

		Customer c=new Customer();
		Wallet w=new Wallet();
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
        Customer c2=c;
		
		Mockito.when(wr.findCustomer("1234567890")).thenReturn(c2);
		
		assertThat(wsl.getCustomerBymobileNo("1234567890")).isEqualTo(c);
	}

	@Test
	void testAddCustomer() {
		Customer c=new Customer();
		Wallet w=new Wallet();
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
		
Mockito.when(wr.save(c)).thenReturn(c);
		
		assertThat(wsl.addCustomer(c)).isEqualTo(c);
	}
//
//	@Test
//	void testDeleteCustomerById() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testGetCustomers() {
		Customer c=new Customer();
		Wallet w=new Wallet();
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
		Customer c1=new Customer();
		Wallet w1=new Wallet();
		c.setCid(2);
		c.setMobileNo("1234567899");
		c.setName("sho");
		c.setPassword("12");
		c.setWallet(w1);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(c);
		customerList.add(c1);
		
		Mockito.when(wr.findAll()).thenReturn(customerList);
		
		assertThat(wsl.getCustomers()).isEqualTo(customerList);
	
		
		
	}

	@Test
	void testShowBalance() throws MobileNumberNotRegistered, InvalidInputException {
		Customer c=new Customer();
		Wallet w=new Wallet();
		BigDecimal b=new BigDecimal(10.00);
		w.setBalance(b);
		w.setWalletId(1);
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);

        Mockito.when(wr.findCustomer("1234567890")).thenReturn(c);
		
		assertThat(wsl.showBalance("1234567890")).isEqualTo(c);
	}
		
	@Test
	void testDepositAmount() throws InvalidInputException, MobileNumberNotRegistered {
		Customer c=new Customer();
		Wallet w=new Wallet();
		BigDecimal b=new BigDecimal(10.00);
		w.setBalance(b);
		w.setWalletId(1);
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
		  Mockito.when(wr.findCustomer("1234567890")).thenReturn(c);
			
			assertThat(wsl.depositAmount("1234567890",b)).isEqualTo(c);
		
	}

	@Test
	void testWithdrawAmount() throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException {
		Customer c=new Customer();
		Wallet w=new Wallet();
		BigDecimal b=new BigDecimal(10.00);
		w.setBalance(b);
		w.setWalletId(1);
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
		  Mockito.when(wr.findCustomer("1234567890")).thenReturn(c);
			
			assertThat(wsl.withdrawAmount("1234567890",b)).isEqualTo(c);
	}

//	@Test
//	void testFundTransfer() throws InvalidInputException, MobileNumberNotRegistered, InsufficientBalanceException {
//		Customer c=new Customer();
//		Wallet w=new Wallet();
//		BigDecimal b=new BigDecimal(20.00);
//		w.setBalance(b);
//		w.setWalletId(1);
//		c.setCid(1);
//		c.setMobileNo("1234567890");
//		c.setName("shohan");
//		c.setPassword("123");
//		c.setWallet(w);
//		
//		Customer c1=new Customer();
//		Wallet w1=new Wallet();
//		BigDecimal b1=new BigDecimal(20.00);
//		w.setBalance(b1);
//		c.setCid(2);
//		c.setMobileNo("1234567899");
//		c.setName("sho");
//		c.setPassword("12");
//		c.setWallet(w1);
//		BigDecimal b2=new BigDecimal(00.00);
//		
//		 Mockito.when(wr.findCustomer("1234567890")).thenReturn(c);
//		 Mockito.when(wr.findCustomer("1234567899")).thenReturn(c1);
//			
//			assertThat(wsl.fundTransfer("1234567890","1234567899",b2)).isEqualTo(c);
//		
//	}


	@Test
	void testUpdateAccount() throws InvalidInputException {
		Customer c=new Customer();
		Wallet w=new Wallet();
		c.setCid(1);
		c.setMobileNo("1234567890");
		c.setName("shohan");
		c.setPassword("123");
		c.setWallet(w);
	Optional<Customer> c2=Optional.of(c);
	
	Mockito.when(wr.findById(1)).thenReturn(c2);
	
	Mockito.when(wr.save(c)).thenReturn(c);
	c.setName("sonu");

	
	assertThat(wsl.updateAccount(c)).isEqualTo(c);
	}


}
