package com.mok.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mok.entity.Account;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Account readByUserId(String userId) {

		String sql = "SELECT a.* FROM Account a WHERE UserId= :UserId";
		Query query = em.createNativeQuery(sql, Account.class);
		query.setParameter("UserId", userId);
		Account account = null;
		try{
			account = (Account) query.getSingleResult();			
		}catch(NoResultException e){			
			account = null;
		}		
		return account;
	}

}
