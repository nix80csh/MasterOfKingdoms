package com.mok.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mok.dto.AuthDto;
import com.mok.dto.JsonDto;
import com.mok.entity.Account;
import com.mok.service.AuthService;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	// private static final org.slf4j.Logger logger =
	// LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthService authService;

	@ResponseBody
	@RequestMapping(value = "/logIn", method = RequestMethod.POST)
	public ResponseEntity<Object> logIn(@RequestBody Account account, HttpServletResponse res) {		
		JsonDto<AuthDto> jDto = authService.auth(account.getUserId(), account.getUdid(), res);
		return new ResponseEntity<Object>(jDto, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Account account) {
		JsonDto<Account> jDto = authService.registration(account);		
		return new ResponseEntity<Object>(jDto, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/readCookie", method = RequestMethod.GET)
	public String readCookie(@CookieValue("X-Auth-Token") String myCookie) {
		return "X-Auth-Token:" + myCookie;
	}

}
