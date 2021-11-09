package com.paymentapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.paymentapp.beans.BillPayment;
import com.paymentapp.beans.BillType;
import com.paymentapp.beans.Wallet;
import com.paymentapp.repo.IBillPaymentRepository;

@SpringBootTest
class IBillPaymentServiceImpTest {
	@Autowired
	IBillPaymentServiceImp billpay;
	
	@MockBean
	
	IBillPaymentRepository repo;
	

	@Test
	void testAddBillPayment() {
		BillPayment bp=new BillPayment();
		BillType bt=BillType.DTH;
		Wallet w=new Wallet();
		LocalDate dt = LocalDate.parse("2018-11-01");
		bp.setBillId(1);
		bp.setBilltype(bt);
		bp.setWallet(w);
		bp.setPaymentDate(dt);
		Mockito.when(repo.save(bp)).thenReturn(bp);
		assertThat(billpay.addBillPayment(bp)).isEqualTo(bp);
		}

	@Test
	void testViewBillPayment() {
		BillPayment bp=new BillPayment();
		BillType bt=BillType.DTH;
		Wallet w=new Wallet();
		LocalDate dt = LocalDate.parse("2021-11-01");
		bp.setBillId(1);
		bp.setBilltype(bt);
		bp.setWallet(w);
		bp.setPaymentDate(dt);
		
		BillPayment bp1=new BillPayment();
		BillType bt1=BillType.LPG;
		Wallet w1=new Wallet();
		LocalDate dt1= LocalDate.parse("2021-11-02");
		bp1.setBillId(2);
		bp1.setBilltype(bt1);
		bp1.setWallet(w1);
		bp1.setPaymentDate(dt1);
		List<BillPayment> bpList=new ArrayList<>();
		bpList.add(bp);
		bpList.add(bp1);
		Mockito.when(repo.findAll()).thenReturn(bpList);
		assertThat(billpay.viewBillPayment()).isEqualTo(bpList);
	}

}
