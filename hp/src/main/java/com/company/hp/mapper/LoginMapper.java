package com.company.hp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.company.hp.entity.AdminData;

@Mapper
public interface LoginMapper {
	
	/**
	 * ログイン
	 * @param adminId
	 * @param isDeleted
	 * @return
	 */
	AdminData getLoginAdmin(@Param("adminId") int adminId,
			@Param("isDeleted") int isDeleted);
	
	/**
	 * ログイン情報取得
	 * @param adminId
	 * @return
	 */
	AdminData findLoginUser(@Param("email") String email, @Param("password") String password);
	
}
