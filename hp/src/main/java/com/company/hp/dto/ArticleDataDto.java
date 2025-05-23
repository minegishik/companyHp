package com.company.hp.dto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import lombok.Data;

/**
 * 記述投稿用DTO
 */
@Data
public class ArticleDataDto {
	
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
	//作成日
	private LocalDateTime createdAt;
	//更新日
	private LocalDateTime updatedAt;
	//公開日
	private LocalDateTime publishedAt;
	
	//公開日が一週間以内の記事にNEW表示を行う
	public boolean isNew() {
        return publishedAt != null &&
               ChronoUnit.DAYS.between(publishedAt, LocalDateTime.now()) <= 7;
    }
}
