package com.company.hp.entity;

import lombok.Data;

/**
 * 記述投稿用エンティティ
 */
@Data
public class ArticleData {

	//記述ID
	private int articleId;
	//タイトル
	private String title;
	//内容
	private String content;
	//公開フラグ
	private int isPublished;
	//削除フラグ
	private int isDeleted;
}
