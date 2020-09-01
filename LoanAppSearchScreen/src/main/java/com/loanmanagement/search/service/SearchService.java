package com.loanmanagement.search.service;
import java.util.List;
import java.util.Optional;

import com.loanmanagement.search.entity.LoanInformation;

public interface SearchService {
	// get all the loans
	public Iterable<LoanInformation> findAll();
	
	// Search by Loan number
	public Optional<LoanInformation> findById(int loanId);
	
	// Search by Loan Amount
	public Optional<List<LoanInformation>> findByAmount(double amount);
	
	
	public Optional<List<LoanInformation>> findByBorrowerName(String borrowerName);
	
	
		public Optional<List<LoanInformation>> findByBorrowerNameAndAmount(String borrowerName, double amount);
		
	    public Optional<List<LoanInformation>> findByNumberAndAmount(int id, double amount);
	    
	  
	    public Optional<List<LoanInformation>> findByNumberAndName(int id, String borrowerName);
		
		public LoanInformation save(LoanInformation loanInfo);
	
	


}