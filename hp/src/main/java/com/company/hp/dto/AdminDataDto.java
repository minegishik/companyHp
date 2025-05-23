package com.company.hp.dto;

import lombok.Data;

/**
* 管理者DTO
*/
@Data
public class AdminDataDto {

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
