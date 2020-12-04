package com.mok.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;

import com.mok.dto.AuthDto;
import com.mok.dto.JsonDto;
import com.mok.entity.Account;

@Transactional
public interface AuthService {	
	JsonDto<Account> registration(Account account); 
	JsonDto<AuthDto> auth(String userId, String udid, HttpServletResponse res);
	
}
