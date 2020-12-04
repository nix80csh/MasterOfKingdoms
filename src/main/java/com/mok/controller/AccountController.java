package com.mok.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mok.dto.JsonDto;
import com.mok.entity.Account;
import com.mok.service.AccountService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AccountService accountService;

	@ResponseBody
	@RequestMapping(value = "/readAccountById", method = RequestMethod.POST)
	public ResponseEntity<Object> readAccountById(@RequestBody Account account) {
		JsonDto<Account> jDto = accountService.readAccountById(account.getIdfAccount());		
		return new ResponseEntity<Object>(jDto, HttpStatus.OK);
	}

}
