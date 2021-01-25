package com.transactions.tcsbankapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transactions.tcsbankapi.exception.ResourceNotFoundException;
import com.transactions.tcsbankapi.model.Transaction;
import com.transactions.tcsbankapi.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction createTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		Optional<Transaction> txDb = this.transactionRepository.findById(transaction.getTxID());
		
		if(txDb.isPresent()) {
			Transaction transactionUpdate = txDb.get();
			transactionUpdate.setTxID(transaction.getTxID());
			transactionUpdate.setTxAmount(transaction.getTxAmount());
			transactionUpdate.setTxStatus(transaction.getTxStatus());
			transactionRepository.save(transactionUpdate);
			return transactionUpdate;
		}
		else {
			throw new ResourceNotFoundException("Transaction Not Found with id: " + transaction.getTxID());
		}
	}

	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return this.transactionRepository.findAll();
	}

	@Override
	public Transaction getTransactionById(long txID) {
		// TODO Auto-generated method stub
		Optional<Transaction> txDb = this.transactionRepository.findById(txID);
		
		if(txDb.isPresent()) {
			return txDb.get();
		}
		else {
			throw new ResourceNotFoundException("Transaction Not Found with id: " + txID);
		}
		
	}

	@Override
	public void deleteTransaction(long txID) {
		// TODO Auto-generated method stub
		Optional<Transaction> txDb = this.transactionRepository.findById(txID);
		
		if(txDb.isPresent()) {
			this.transactionRepository.delete(txDb.get());
		}
		else {
			throw new ResourceNotFoundException("Transaction Not Found with id: " + txID);
		}
		
	}
		
	}
