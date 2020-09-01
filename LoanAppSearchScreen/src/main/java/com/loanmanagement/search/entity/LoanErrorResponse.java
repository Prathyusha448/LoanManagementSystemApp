package com.loanmanagement.search.entity;

public class LoanErrorResponse {

	private int status;
	
	private String message;
	
	
	public LoanErrorResponse() {
		
	}


	public LoanErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}


	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}