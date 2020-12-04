package com.mok.dao;

import com.mok.entity.Account;

public interface AccountDao extends GenericDao<Account> {
	Account readByUserId(String userId);
}
