package com.capg.go.cms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/****************************************************************************************************************************
- File Name        : GlobalExceptionHandler.java 
- Author           : Srinidhi
- Creation Date    : 21/09/2020
- Updated Date     : 23/09/2020
- Description      : This Controller class act as an end point to manage and handle the entire Exceptions
****************************************************************************************************************************/

@ControllerAdvice
public class GlobalExceptionHandler {

	/****************************************************************************************************************************
	  - Method Name         : handleCartException
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : This method handles the  CartException
	 ****************************************************************************************************************************/
	
	@ExceptionHandler(CartException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleException(CartException ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);

		return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************************************************
	  - Method Name         : handleProductException
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : This method handles the  ProductException
	 ****************************************************************************************************************************/
	
	@ExceptionHandler(ProductException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleException(ProductException ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);

		return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}

	/****************************************************************************************************************************
	  - Method Name         : handleLoginException
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : This method handles the LoginException
	 ****************************************************************************************************************************/
	
	@ExceptionHandler(LoginException.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleException(LoginException ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);

		return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}
	
	/****************************************************************************************************************************
	  - Method Name         : handleException
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : This method handles the Exception
	 ****************************************************************************************************************************/
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<ErrorInfo> handleException(Exception ex, HttpServletRequest req) {

		String message = ex.getMessage();
		String uri = req.getRequestURI();

		ErrorInfo obj = new ErrorInfo(LocalDateTime.now(), message, uri);

		return new ResponseEntity<>(obj, HttpStatus.NOT_FOUND);
	}

}
