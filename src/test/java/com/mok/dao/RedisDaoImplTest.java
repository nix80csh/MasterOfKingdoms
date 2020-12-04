package com.mok.dao;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mok.entity.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:root-context.xml", "classpath:security-context.xml",
		"classpath:redis-context.xml" })
@Transactional
public class RedisDaoImplTest {

	@Autowired
	private RedisDao redisDao;
	@Autowired
	private AccountDao accountDao;

	private String expected;
	@Test
	public void testSetValue() {
		
	}

	@Test
	public void testGetValue() {
		
	}

}
