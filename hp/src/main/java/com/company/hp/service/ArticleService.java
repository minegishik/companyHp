package com.company.hp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hp.dto.ArticleDataDto;
import com.company.hp.mapper.ArticleMapper;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	/**
	 * 記事情報全件取得
	 * @return
	 */
	public List<ArticleDataDto> getAllArticle(){
		
		return articleMapper.getAllArticleData();
	}
	
	
	/**
	 * 公開中記事のみ取得
	 * @param isPublished
	 * @param isDeleted
	 * @return
	 */
	public List<ArticleDataDto> getArticle(int isPublished, int isDeleted){
			
		return articleMapper.getArticleData(isPublished, isDeleted);
	}
	
	
	/**
	 * 一般ユーザー選択記事情報取得
	 * @param articleId
	 * @return
	 */
	public ArticleDataDto findArticleData(int articleId) {
		
		return articleMapper.findArticleData(articleId);
	}
	

}
