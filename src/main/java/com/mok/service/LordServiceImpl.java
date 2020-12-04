package com.mok.service;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mok.dao.AccountDao;
import com.mok.dao.LordDao;
import com.mok.dto.JsonDto;
import com.mok.entity.Lord;

@Service
public class LordServiceImpl implements LordService {

	@Autowired
	LordDao lordDao;
	@Autowired
	AccountDao accountDao;

	@Override
	public JsonDto<Lord> registration(Lord lord) {

		JsonDto<Lord> jDto = new JsonDto<Lord>();

		// 계정에 존재하지 않은 영주데이터를 받았을때
		if (accountDao.readById(lord.getIdfAccount()) == null) {
			jDto.setResultCode("F");
			jDto.setResultMessage("Does not exist Account Entity");
		} else {	// 계정에 존재하면서
			// 영주에 존재하지 않을때
			if (lordDao.readById(lord.getIdfAccount()) == null) {

				System.out.println("진입");

				lord.setRegDate(new Date());
				lordDao.create(lord);
				jDto.setResultCode("S");
				jDto.setResultMessage("Created");

			} else {	// 영주에 존재할때

				jDto.setData(null);
				jDto.setResultCode("F");
				jDto.setResultMessage("Exist Lord Entity");
			}
		}

		return jDto;
	}

}
