package com.mok.service;

import org.springframework.transaction.annotation.Transactional;

import com.mok.dto.JsonDto;

import com.mok.entity.Lord;

@Transactional
public interface LordService {
	JsonDto<Lord> registration(Lord lord);

}
