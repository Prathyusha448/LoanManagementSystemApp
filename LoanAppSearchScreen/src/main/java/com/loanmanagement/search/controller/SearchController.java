package com.loanmanagement.search.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanmanagement.search.entity.LoanInformation;
import com.loanmanagement.search.exception.LoanNotFoundException;
import com.loanmanagement.search.service.SearchServiceImpl;

@RestController
@RequestMapping("/search")
public class SearchController {
	

	public SearchController() {
	}
	
	@Autowired
	private SearchServiceImpl searchService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	List<LoanInformation> loanList = new ArrayList<LoanInformation>();
	
	Iterable<LoanInformation> loanIterator;
	

    @GetMapping("/loan")
	public List<LoanInformation> findAll() {
    	
    	loanIterator = searchService.findAll();
    	
    	loanIterator.forEach(loanList::add);
			
		return loanList;
			
	}
		
	
	@GetMapping("/loan/{id}")
	public LoanInformation findById(@PathVariable("id") int loanId) {
		
		Optional<LoanInformation> loanInfo = searchService.findById(loanId);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the loan id " +loanId));
		 
		return loanInfo.get();
		
	}
	
	
	@GetMapping("/loanByAmount/{amount}")
	public List<LoanInformation> findByAmount(@PathVariable("amount") double amount) {
		
        List<LoanInformation> loanList = null;
		
		Optional<List<LoanInformation>> loanInfo = searchService.findByAmount(amount);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found wiht the loan amount " +amount));
		
		for(LoanInformation loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;		
	}
	
	
	@GetMapping("/loanByBorrowerName/{borrowerName}")
	public List<LoanInformation> findByBorrowerName(@PathVariable("borrowerName") String borrowerName) {
			
        List<LoanInformation> loanList = null;
		
		Optional<List<LoanInformation>> loanInfo = searchService.findByBorrowerName(borrowerName);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name " +borrowerName));
		
		for(LoanInformation loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;
			
	}
	
	
	

	   @GetMapping("/loanByNameAndAmount/{borrowerName}/{amount}")
	   public List<LoanInformation> findByBorrowerNameAndAmount(@PathVariable("borrowerName") String borrowerName
			  , @PathVariable("amount") double amount) {
			
	       List<LoanInformation> loanList = null;
		
		   Optional<List<LoanInformation>> loanInfo = searchService.findByBorrowerNameAndAmount(borrowerName, amount);
		
		   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name and amount" 
		                 +borrowerName+ "," +amount));
		
		   for(LoanInformation loan : loanInfo.get()) {
			
			   loanList= Arrays.asList(loan);	
		   }		
		   return loanList;
			
	     }
	   
	  
	   @GetMapping("/loanByNumberAndAmount/{id}/{amount}")
	   public List<LoanInformation> findByNumberAndAmount(@PathVariable("id") int id
			  , @PathVariable("amount") double amount) {
			
	       List<LoanInformation> loanList = null;
		
		   Optional<List<LoanInformation>> loanInfo = searchService.findByNumberAndAmount(id, amount);
		
		   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name and amount" 
		                 +id+ "," +amount));
		
		   for(LoanInformation loan : loanInfo.get()) {
			
			   loanList= Arrays.asList(loan);	
		   }		
		   return loanList;
			
	     }
	   
	 
	   @GetMapping("/loanByNumberAndName/{id}/{borrowerName}")
	   public List<LoanInformation> findByNumberAndName(@PathVariable("id") int id
			  , @PathVariable("borrowerName") String borrowerName) {
			
	       List<LoanInformation> loanList = null;
		
		   Optional<List<LoanInformation>> loanInfo = searchService.findByNumberAndName(id, borrowerName);
		
		   loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the loan number and borrower name" 
		                 +id+ "," +borrowerName));
		
		   for(LoanInformation loan : loanInfo.get()) {
			
			   loanList= Arrays.asList(loan);	
		   }		
		   return loanList;
			
	     }
	   
		
		
		@PostMapping("/loan")
		public LoanInformation createLoan(@RequestBody LoanInformation loanInfo) {
			
			return searchService.save(loanInfo);
		}
		
		
		

	}