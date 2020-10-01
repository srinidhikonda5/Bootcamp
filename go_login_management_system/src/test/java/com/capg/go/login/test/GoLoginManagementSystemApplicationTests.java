package com.capg.go.login.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.go.login.dao.LoginDao;
import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;

/****************************************************************************************************************************
- File Name        : GoLoginManagementSystemApplicationTests.java 
- Author           : Srinidhi 
- Creation Date    : 20/09/2020
- Modified Date    : 23/09/2020
****************************************************************************************************************************/
@SpringBootTest
class GoLoginManagementSystemApplicationTests {

	@Autowired
	LoginDao loginDao;

	@Test
	void testLogin() throws LoginException {
		Login login = loginDao.validate("SrinidhiKonda", "srinidhi");
		assertNotNull(login);

	}

	@Test
	void testLoginNotExist() throws LoginException {
		Login login = loginDao.validate("abc", "abc23");
		assertNull(login);

	}

	@Test
	void testFindUserExist() throws LoginException {
		Login login = loginDao.FindUser("SrinidhiKonda");
		assertEquals("SrinidhiKonda", login.getUserName());

	}

	@Test
	void testFindUserNotExist() throws LoginException {

		Login login = loginDao.FindUser("abc");
		assertNull(login);

	}

}
