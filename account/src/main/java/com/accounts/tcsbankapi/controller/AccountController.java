/**
 * 
 */
package com.transactions.tcsbankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.tcsbankapi.model.Transaction;
import com.transactions.tcsbankapi.service.TransactionService;

/**
 * @author Sibani Majhi
 *
 */
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Transaction>> getAllAccount() {
		return ResponseEntity.ok().body(accountService.getAllAccount());
	} 
	
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable long id) {
		return ResponseEntity.ok().body(accountService.getAccountById(id));
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.ok().body(this.accountService.createAccount(account));
	}
	
	@PutMapping("/accounts")
	public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account account) {
		transaction.setTxID(id);
		return ResponseEntity.ok().body(this.transactionService.updateTransaction(transaction));
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteTransaction(@PathVariable long id) {
		this.transactionService.deleteTransaction(id);
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
	}
}

















