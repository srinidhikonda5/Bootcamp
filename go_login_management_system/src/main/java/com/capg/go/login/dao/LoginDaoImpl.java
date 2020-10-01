package com.capg.go.login.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.go.login.exception.LoginException;
import com.capg.go.login.model.Login;


/****************************************************************************************************************************
- File Name        : LoginDaoImpl.java 
- Author           : Srinidhi
- Creation Date    : 21/09/2020
- Description      : LoginDaoImpl class is responsible for accessing the data through database
****************************************************************************************************************************/

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Login validate(String userName, String password) throws LoginException {
		String qry = "select u from Login u where u.userName=:userName and u.userPass=:userPass";
		TypedQuery<Login> query = em.createQuery(qry, Login.class);
		query.setParameter("userName", userName);
		query.setParameter("userPass", password);
		Login login = null;
		List<Login> list = query.getResultList();
		if (!list.isEmpty())
			login = list.get(0);

		return login;
	}

	@Override
	public Login create(Login login) throws LoginException {

		em.persist(login);
		return login;
	}

	@Override
	public Login FindUser(String userName) throws LoginException {

		Login login = em.find(Login.class, userName);

		return login;
	}

}
