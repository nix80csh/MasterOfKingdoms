package com.mok.service;

import java.util.Date;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mok.auth.TokenUtils;
import com.mok.dao.AccountDao;
import com.mok.dao.RedisDao;
import com.mok.dto.AuthDto;
import com.mok.entity.Account;
import com.mok.dto.AuthDto;
import com.mok.dto.JsonDto;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private RedisDao redisTestDao;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public JsonDto<AuthDto> auth(String userId, String udid, HttpServletResponse res) {

		// 인증
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userId, udid);
		Authentication authentication = this.authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// 토큰생성
		Account account = accountDao.readByUserId(userId);
		String xAuthToken = TokenUtils.createToken(account);

		// 레디스 Insert
		redisTestDao.setValue(xAuthToken, account);
		
		// 쿠키생성
		Cookie cookie = new Cookie("X-Auth-Token", xAuthToken);
		res.addCookie(cookie);
		
		
		AuthDto dto = new AuthDto();
		dto.setIdfAccount(account.getIdfAccount());
		dto.setxAuthToken(xAuthToken);
		
		// json format설정
		JsonDto<AuthDto> jDto = new JsonDto<AuthDto>();
		jDto.setResultCode("S");
		jDto.setData(dto);

		return jDto;
	}

	@Override
	public JsonDto<Account> registration(Account account) {
		
		JsonDto<Account> jDto = new JsonDto<Account>();		
		Account _account = accountDao.readByUserId(account.getUserId());
		if(_account == null){
			account.setRegDate(new Date());
			accountDao.create(account);
			jDto.setResultCode("S");
			jDto.setResultMessage("Created");
		}else{
			jDto.setResultCode("F");
			jDto.setResultMessage("Duplicate UserId");		
		}		
		return jDto;
	}

}
