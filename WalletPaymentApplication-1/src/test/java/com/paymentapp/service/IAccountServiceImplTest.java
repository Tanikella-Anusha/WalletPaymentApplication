package com.paymentapp.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.beans.Wallet;
import com.paymentapp.repo.IAccountRepository;
@SpringBootTest
class IAccountServiceImplTest {
	
	@Autowired
	IAccountServiceImpl iaccountservice;
	
	@MockBean
	IAccountRepository accrepo;

	@Test
	void testAddAccount() {
		BankAccount  ba=new  BankAccount ();
		Wallet w=new Wallet();
		ba.setAccountNo(111);
		ba.setBalance(300.0);
		ba.setBankName("SBI");
		ba.setIfscCode("SBIN001");
		ba.setWallet(w);
		
		Mockito.when(accrepo.save(ba)).thenReturn(ba);
		assertThat(iaccountservice.addAccount(ba)).isEqualTo(ba);
		
	}
	@Test
	void testViewAllAccounts() {
		BankAccount  ba=new  BankAccount ();
		Wallet w=new Wallet();
		ba.setAccountNo(111);
		ba.setBalance(20.0);
		ba.setBankName("SBI");
		ba.setIfscCode("SBIN001");
		ba.setWallet(w);
		BankAccount  ba1=new  BankAccount ();
		Wallet w1=new Wallet();
		ba1.setAccountNo(222);
		ba1.setBalance(200.0);
		ba1.setBankName("HDFC");
		ba1.setIfscCode("HDFCN001");
		ba1.setWallet(w1);
		List<BankAccount> baList=new ArrayList<>();
		baList.add(ba);
		baList.add(ba1);
		Mockito.when(accrepo.findAll()).thenReturn(baList);
		assertThat(iaccountservice.viewAllAccounts()).isEqualTo(baList);
	}
	@Test
	void testRemoveAccount() {
		BankAccount  ba=new  BankAccount ();
		Wallet w=new Wallet();
		ba.setAccountNo(111);
		ba.setBalance(20.0);
		ba.setBankName("SBI");
		ba.setIfscCode("SBIN001");
		ba.setWallet(w);
		Optional<BankAccount> ba1=Optional.of(ba);
		Mockito.when(accrepo.findById(111)).thenReturn(ba1);
		Mockito.when(accrepo.existsById(ba.getAccountNo())).thenReturn(false);
		assertFalse(accrepo.existsById(ba.getAccountNo()));
		
	}
	@Test
	void testGetAccountById()throws Throwable  {
		BankAccount  ba=new  BankAccount ();
		Wallet w=new Wallet();
		ba.setAccountNo(111);
		ba.setBalance(20.0);
		ba.setBankName("SBI");
		ba.setIfscCode("SBIN001");
		ba.setWallet(w);
		Optional<BankAccount> ba1=Optional.of(ba);
		Mockito.when(accrepo.findById(111)).thenReturn(ba1);
		assertThat(iaccountservice.getAccountById(111)).isEqualTo(ba);
		
	}

}

