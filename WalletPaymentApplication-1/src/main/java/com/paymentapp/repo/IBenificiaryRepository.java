package com.paymentapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentapp.beans.BenificiaryDetails;

@Repository
public interface IBenificiaryRepository extends JpaRepository<BenificiaryDetails,Integer> {
	
	BenificiaryDetails findByMobileNumber(String mobileNumber);

}
