package com.capg.go.cms.exception;

import java.time.LocalDateTime;

/****************************************************************************************************************************
- File Name        : ErrorInfo.java 
- Author           : Srinidhi
- Creation Date    : 21/09/2020
- Updated Date     : 23/09/2020
- Description      : This class act as an end point to manage errors
****************************************************************************************************************************/

public class ErrorInfo {
	private LocalDateTime timestamp;
	private String errorMessage;
	private String details;

	public ErrorInfo(LocalDateTime timestamp, String errorMessage, String details) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public ErrorInfo() {
		super();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
