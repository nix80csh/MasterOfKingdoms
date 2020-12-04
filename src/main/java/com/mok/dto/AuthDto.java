package com.mok.dto;

import javax.persistence.Entity;


public class AuthDto {
	private Integer idfAccount;
	private String xAuthToken;
	
	public Integer getIdfAccount() {
		return idfAccount;
	}
	public void setIdfAccount(Integer idfAccount) {
		this.idfAccount = idfAccount;
	}
	public String getxAuthToken() {
		return xAuthToken;
	}
	public void setxAuthToken(String xAuthToken) {
		this.xAuthToken = xAuthToken;
	}
	
}
