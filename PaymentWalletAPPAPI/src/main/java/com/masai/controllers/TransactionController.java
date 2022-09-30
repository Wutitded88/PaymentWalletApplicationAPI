package com.masai.controllers;
import com.masai.exception.CustomerNotException;
import com.masai.model.Transaction;
import com.masai.model.Wallet;
import com.masai.service.TranscationServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private TranscationServiceImpl transactionserviceimpl;
	
	
	
//	public Transaction addTranscation(Transaction tran);
	
	public ResponseEntity<Transaction> addTransactionHandeler(Transaction tran){
		
		Transaction transaction = transactionserviceimpl.addTranscation(tran);
		
		return new ResponseEntity<Transaction>(transaction,HttpStatus.OK);
	}
	
	
	
//	public Set<Transaction> viewAlltransaction(Wallet wallet) throws CustomerNotException;
	@GetMapping("/transation_histroy")
	public ResponseEntity<Set<Transaction>> viewAllTransactionHandler( @RequestBody Wallet wallet) throws CustomerNotException{
		
		Set<Transaction> allTransaction = transactionserviceimpl.viewAlltransaction(wallet);
		
		return new ResponseEntity<Set<Transaction>>(allTransaction,HttpStatus.OK);
	}
	
	
	
	
//	public Set<Transaction> viewTranscationByDate(LocalDate from, LocalDate to);
	@GetMapping("/historyByDate")
	public ResponseEntity<Set<Transaction>> viewTransactionByDatehandler(LocalDate from,LocalDate to){
		
		Set<Transaction> historyByDate= transactionserviceimpl.viewTranscationByDate(from, to);
		
		return new ResponseEntity<Set<Transaction>>(historyByDate,HttpStatus.OK);
	}
	
	
	
	
	
//	public Set<Transaction> viewAllTransaction(String type);
	@GetMapping("/historybytype/{type}")
	public ResponseEntity<Set<Transaction>> viewAllTransactionByTypeHandler(@PathParam("transactiontype") String type){
		
		Set<Transaction> TransactionType = transactionserviceimpl.viewAllTransaction(type);
		
		return new ResponseEntity<Set<Transaction>>(TransactionType,HttpStatus.OK);
	}
	
	
}
