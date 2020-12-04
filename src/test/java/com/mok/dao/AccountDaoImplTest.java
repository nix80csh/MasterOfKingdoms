package com.mok.dao;

import java.util.Date;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mok.entity.Account;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:security-context.xml",
		"classpath:redis-context.xml" })
@Transactional
public class AccountDaoImplTest {

	@Autowired
	private AccountDao accountDao;

	@BeforeClass
	public static void setUp() {
		System.out.println("@BeforeClass setUp");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("@AfterClass tearDown");
	}

	@Test
	public void testReadByUserId() {

		// 데이터 생성
		Account account = new Account();
		account.setUserId("nix80csh@naver.1com");
		account.setUdid("PW:nix80csh@naver.1com");
		account.setRecentLogin(new Date());
		account.setRegDate(new Date());
		account.setState('F');

		// 데이터 입력
		accountDao.create(account);

		// 입력한 데이터 검증
		String userId = account.getUserId();
		Account account1 = accountDao.readByUserId(userId);
		Assert.assertEquals("nix80csh@naver.1com", account1.getUserId());

		// 존재하지 않은 데이터로 조회했을때
		String notExistUserId = "";
		Account account2 = accountDao.readByUserId(notExistUserId);
		Assert.assertEquals(null, account2);

		return;

	}

}
