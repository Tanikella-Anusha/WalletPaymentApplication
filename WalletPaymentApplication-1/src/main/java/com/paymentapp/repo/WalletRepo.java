package com.paymentapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paymentapp.beans.Customer;
import com.paymentapp.beans.Wallet;
@Repository
public interface WalletRepo extends JpaRepository<Customer, Integer> {
	@Query("Select c from Customer c where mobileNo=:mobileNo")
	public Customer findCustomer(@Param("mobileNo") String mobileNo);
//@Query("Select c.mobileNo from Customer c")
//public Customer findbymobileNo(@Param("mobileNo") String mobileNo);
//	@Query("Select c from Customer c where c.mobileNo=: mobileNo")
//	public Customer findOne(@Param("mobileNo") String mobileNo);

}
