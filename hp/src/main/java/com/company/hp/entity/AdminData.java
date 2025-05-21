package com.company.hp.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 管理者エンティティ
 */
@Data
@Component
public class AdminData {
	
	//管理者ID
	private int adminId;
	//管理者名
	private String username;
	//パスワード
	private String password;
	//メールアドレス
	private String email;
	//削除フラグ
	private int isDeleted;

}
