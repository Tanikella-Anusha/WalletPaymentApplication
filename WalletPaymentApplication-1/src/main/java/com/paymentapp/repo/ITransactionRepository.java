package com.paymentapp.repo;

import java.sql.Date;
import java.time.LocalDate;

import java.util.List;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paymentapp.beans.Transaction;
import com.paymentapp.beans.Wallet;

@Repository
@EnableJpaRepositories
public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
	

@Query("select t from Transaction t where transactionType=:transactionType")
public Transaction viewTransaction(@Param("transactionType") String transactionType);
	 

 @Query("from Transaction t where t.transactionDate between :from and :to")
public List<Transaction> viewTransactionByDate(@Param("from")Date from,@Param("to")Date to);

}
