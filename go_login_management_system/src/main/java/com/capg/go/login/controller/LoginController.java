package com.capg.go.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;
import com.capg.go.login.service.LoginService;

/****************************************************************************************************************************
- File Name        : LoginController.java 
- Author           : Srinidhi 
- Creation Date    : 22/09/2020
- Modified Date    : 24/09/2020
- Description      : This Controller class act as an end point to manage the entire LoginService
****************************************************************************************************************************/

@RestController
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	LoginService service;

	/****************************************************************************************************************************
	  - Method Name         : validate
	  - Input Parameters    : username and userpassword
	  - Return Type         : logindetails
	  - End Point Url       : /login/validate/{user}/{pass}
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : Getting the login details from the database
	 ****************************************************************************************************************************/
	
	@GetMapping("/login/validate/{user}/{pass}")
	public ResponseEntity<Login> validate(@PathVariable("user") String user, @PathVariable("pass") String pass)
			throws LoginException {

		Login login = service.validate(user, pass);
		ResponseEntity<Login> re = new ResponseEntity<>(login, HttpStatus.OK);
		return re;
	}

	/****************************************************************************************************************************
	  - Method Name         : valiadte
	  - Input Parameters    : enter details
	  - Return Type         : logindetails
	  - End Point Url       : /login
	  - Request Method Type : PostMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : Creating Login
	 ****************************************************************************************************************************/
	
	@PostMapping("/login")
	public ResponseEntity<Login> validate(@RequestBody Login login) throws LoginException {

		login = service.create(login);
		ResponseEntity<Login> re = new ResponseEntity<>(login, HttpStatus.OK);
		return re;
	}

}
