package com.paymentapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentapp.beans.BillPayment;
@Repository
public interface IBillPaymentRepository extends JpaRepository<BillPayment, Integer> {

}
