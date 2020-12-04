package com.mok.controller;

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
import com.mok.entity.Lord;
import com.mok.service.LordService;

@Controller
@RequestMapping(value="/lord")
public class LordController {

	
	@Autowired
	LordService lordService;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
				
		return "LordTest";
	}	
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Object> register(@RequestBody Lord lord) {
		JsonDto<Lord> jDto = lordService.registration(lord);		
		return new ResponseEntity<Object>(jDto, HttpStatus.OK);
	}	
}
