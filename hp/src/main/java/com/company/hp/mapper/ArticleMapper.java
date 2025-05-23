package com.company.hp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.company.hp.dto.ArticleDataDto;

@Mapper
public interface ArticleMapper {
	
	/**
	 * 管理者用記事情報全件取得
	 * @return
	 */
	List<ArticleDataDto> getAllArticleData();
	
	
	/*一般用記事情報公開のみ取得*
	 * 
	 * @param isPublished
	 * @return
	 */
	List<ArticleDataDto> getArticleData(@Param("isPublished") int isPublished,
			@Param("isDeleted") int isDeleted);
	
	
	/**
	 * 一般ユーザー選択記事取得
	 * @param articleId
	 * @return
	 */
	ArticleDataDto findArticleData(@Param("articleId") int articleId);

}
