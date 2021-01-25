package com.transactions.tcsbankapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.transactions.tcsbankapi.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	
}
