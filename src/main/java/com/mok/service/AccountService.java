package com.mok.service;

import org.springframework.transaction.annotation.Transactional;

import com.mok.dto.JsonDto;
import com.mok.entity.Account;

@Transactional
public interface AccountService {	
	//void create(Account account);	
	@Transactional(readOnly=true)
	JsonDto<Account> readAccountById(int id);	

}
