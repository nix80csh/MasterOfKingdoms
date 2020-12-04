package com.mok.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;


import com.mok.entity.Account;

import redis.clients.jedis.Jedis;

@Repository
public class RedisDaoImpl implements RedisDao {

	@Autowired
	private RedisTemplate<String, Account> redisTemplate;

	@Override
	public void setValue(String key, Account account) {
		redisTemplate.opsForValue().set("X-Auth-Token:" + key, account);
	}

	@Override
	public Account getValue(String key, String idfAccount) {
		return (Account) redisTemplate.opsForHash().get("X-Auth-Token:" + key, idfAccount);
	}

}
