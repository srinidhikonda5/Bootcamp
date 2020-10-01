package com.capg.go.login.dao;

import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;

/****************************************************************************************************************************
- File Name        : LoginDao.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Modified Date    : 22/09/2020
****************************************************************************************************************************/

public interface LoginDao {

	public Login validate(String userName, String password) throws LoginException;

	public Login create(Login login) throws LoginException;

	public Login FindUser(String userName) throws LoginException;
}
