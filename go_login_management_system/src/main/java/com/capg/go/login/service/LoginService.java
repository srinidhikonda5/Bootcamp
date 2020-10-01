package com.capg.go.login.service;

import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;

/****************************************************************************************************************************
- File Name        : LoginService.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Modified Date    : 22/09/2020
****************************************************************************************************************************/

public interface LoginService {

	public Login validate(String userName, String password) throws LoginException;

	public Login create(Login login) throws LoginException;

}
