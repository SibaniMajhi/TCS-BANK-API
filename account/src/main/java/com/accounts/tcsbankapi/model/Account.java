package com.transactions.tcsbankapi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerID;
	
	@Column()
	private long accountNo;
	
	@Column()
	private String accountType;
	
	@Column()
	private BigDecimal amount;
	
	@CreationTimestamp
	private Date creationDate;
	
	@Column()
	private String brCode; 
	
	
}
