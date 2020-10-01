package com.capg.go.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************************************************************************************************************
- File Name        : Login.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Description      : Login Bean class
****************************************************************************************************************************/

@Entity
@Table(name = "login_table")
public class Login {
	@Id
	@Column(name = "user_name", length = 20)
	private String userName;
	
	@Column(name = "password", length = 20)
	private String userPass;
	
	@Column(name = "phone_no")
	private long phoneNumber;
	
	@Column(name = "email_id", length = 40)
	private String emailId;
	
	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String userName, String userPass, long phoneNumber, String emailId, String role) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", userPass=" + userPass + ", phoneNumber=" + phoneNumber + ", emailId="
				+ emailId + ", role=" + role + "]";
	}

}
