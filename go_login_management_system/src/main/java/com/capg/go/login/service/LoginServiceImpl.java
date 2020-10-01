package com.capg.go.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.go.login.dao.LoginDao;
import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;


/****************************************************************************************************************************
- File Name        : LoginServiceImpl.java 
- Author           : Srinidhi 
- Creation Date    : 22/09/2020
- Modified Date    : 24/08/2020
****************************************************************************************************************************/

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	/****************************************************************************************************************************
	  - Method Name         : validate
	  - Author              : Srinidhi 
	  - Creation Date       : 22/09/2020
	  - Description         : Method to validate Login details
	 ****************************************************************************************************************************/
	
	@Override
	public Login validate(String userName, String userPass) throws LoginException {
		Login login = loginDao.validate(userName, userPass);
		if (login == null) {
			throw new LoginException("Login Failed");
		}
		return login;
	}

	/****************************************************************************************************************************
	  - Method Name         : create
	  - Author              : Srinidhi 
	  - Creation Date       : 22/09/2020
	  - Description         : Method to create login
	 ****************************************************************************************************************************/
	
	@Override
	public Login create(Login login) throws LoginException {
		Login login1 = loginDao.FindUser(login.getUserName());
		if (login1 != null) {
			throw new LoginException("User Already Exists");
		}

		return loginDao.create(login);
	}

}
