package com.mok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mok.dao.AccountDao;
import com.mok.dto.JsonDto;
import com.mok.entity.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	public JsonDto<Account> readAccountById(int id) {	
		Account account = accountDao.readById(id);
		JsonDto<Account> jDto = new JsonDto<Account>();
		if (account == null) {
			jDto.setResultCode("F");
			jDto.setResultMessage("Does not exist");
		} else {
			jDto.setResultCode("S");
			jDto.setData(account);
		}		
		return jDto;		
	}



}
