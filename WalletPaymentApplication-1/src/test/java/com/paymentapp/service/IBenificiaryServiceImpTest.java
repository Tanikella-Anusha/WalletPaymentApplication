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

import com.paymentapp.beans.BenificiaryDetails;
import com.paymentapp.repo.IBenificiaryRepository;
@SpringBootTest
class IBenificiaryServiceImpTest {
	@Autowired
	IBenificiaryServiceImp ibenificiary;
	
	@MockBean
	IBenificiaryRepository repo;
	

	@Test
	void testAddBenificiary() {
		BenificiaryDetails bd=new BenificiaryDetails();
		bd.setBenificiaryId(1);
		bd.setMobileNumber("9988774455");
		bd.setName("Sam");
		Mockito.when(repo.save(bd)).thenReturn(bd);
		assertThat(ibenificiary.addBenificiary(bd)).isEqualTo(bd);
	}

	@Test
	void testUpdateBenificiary() throws Throwable{
		
		BenificiaryDetails bd=new BenificiaryDetails();
		bd.setBenificiaryId(1);
		bd.setMobileNumber("9988774455");
		bd.setName("Sam");
		Optional<BenificiaryDetails> bd1=Optional.of(bd);
		Mockito.when(repo.findById(1)).thenReturn(bd1);
		Mockito.when(repo.save(bd)).thenReturn(bd);
		bd.setMobileNumber("9988773322");
		bd.setName("Anu");
		assertThat(ibenificiary.updateBenificiary(bd)).isEqualTo(bd);
	}

	@Test
	void testDeleteBenificiary() {
		BenificiaryDetails bd=new BenificiaryDetails();
		bd.setBenificiaryId(1);
		bd.setMobileNumber("9988774455");
		bd.setName("Sam");
		Optional<BenificiaryDetails> bd1=Optional.of(bd);
		Mockito.when(repo.findById(1)).thenReturn(bd1);
		Mockito.when(repo.existsById(bd.getBenificiaryId())).thenReturn(false);
		assertFalse(repo.existsById(bd.getBenificiaryId()));
		
	}

	@Test
	void testViewBenificiary() {
		BenificiaryDetails bd=new BenificiaryDetails();
		bd.setBenificiaryId(1);
		bd.setMobileNumber("9988774455");
		bd.setName("Sam");
		BenificiaryDetails bd1=bd;
		Mockito.when(repo.findByMobileNumber("9988774455")).thenReturn(bd1);
		assertThat(ibenificiary.viewBenificiary("9988774455")).isEqualTo(bd);
	}

	@Test
	void testViewAllBenificiary() {
		
		BenificiaryDetails bd=new BenificiaryDetails();
		bd.setBenificiaryId(1);
		bd.setMobileNumber("9988774455");
		bd.setName("Sam");
		
		BenificiaryDetails bd1=new BenificiaryDetails();
		bd1.setBenificiaryId(1);
		bd1.setMobileNumber("9988776611");
		bd1.setName("Ram");
		List<BenificiaryDetails> bdList=new ArrayList<>();
		bdList.add(bd);
		bdList.add(bd1);
		
		Mockito.when(repo.findAll()).thenReturn(bdList);
		assertThat(ibenificiary.viewAllBenificiary()).isEqualTo(bdList);
	}

}

