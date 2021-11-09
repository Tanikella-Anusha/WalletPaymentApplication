package com.paymentapp.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paymentapp.beans.BankAccount;
import com.paymentapp.beans.Wallet;

@Repository
public interface IAccountRepository extends JpaRepository<BankAccount,Integer>
{
//	@Query("select w from Wallet w")
//	public List<Wallet> addAccount(BankAccount bacc);
	@Query("DELETE from BankAccount ba where ba.accountNo=:accountNo")
	public Wallet removeAccount(@Param("accountNo") Integer accountNo);
	
	//@Query("select from BankAccount ba where ba.accountNo=:accountNo")
	//public Wallet viewAccount(@Param("accountNo")Integer accountNo);
	
	//@Query("select w from Wallet w")
	//public BankAccount viewAccount(BankAccount bacc);
	
	//@Query("select from Wallet w where ba.accountNo=:accountNo")
	//public List<Wallet> viewAllAccounts(@Param("accountNo") Integer accountNo);
	
	//@Query("select from BankAccount ba where ba.accountNo=:accountNo")
	//public List<Wallet> viewAllAccounts();
	
}
