package com.mok.dao;

import com.mok.entity.Account;

public interface RedisDao {

	void setValue(String key, Account account);
	Account getValue(String key, String idfAccount);
	
}
