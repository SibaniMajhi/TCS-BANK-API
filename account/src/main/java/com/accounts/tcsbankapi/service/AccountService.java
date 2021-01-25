package com.transactions.tcsbankapi.service;
import java.util.List;
import com.transactions.tcsbankapi.model.Transaction;

public interface TransactionService {

	Transaction createTransaction(Transaction transaction);
	
	Transaction updateTransaction(Transaction transaction);
	 
	List<Transaction> getAllTransaction();
	
	Transaction getTransactionById(long txID);
	
	void deleteTransaction(long id);
}
