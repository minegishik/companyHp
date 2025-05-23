package com.company.hp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hp.entity.AdminData;
import com.company.hp.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	/**
	 * ログイン情報取得
	 * @param email
	 * @param password
	 * @return
	 */
	public AdminData findLoginUser(String email, String password) {

		return loginMapper.findLoginUser(email, password);
	}

}
