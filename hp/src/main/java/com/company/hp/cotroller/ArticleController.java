package com.company.hp.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.hp.dto.ArticleDataDto;
import com.company.hp.entity.AdminData;
import com.company.hp.service.ArticleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 一般ユーザー/管理者 記事一覧画面
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(HttpSession session,Model model) {
		
		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		
		//ログイン状況で取得データを分岐する
		if(loginUser == null) {
			
		List<ArticleDataDto> articleList = articleService.getArticle(1,0);		
		model.addAttribute("articleList",articleList);
		
		} else if(loginUser != null)	{
			
			List<ArticleDataDto> adminArticleList = articleService.getAllArticle();		
			model.addAttribute("adminArticleList",adminArticleList);
						
		}
		
		return "article/list";
	}
	
	/*
	 * 一般ユーザー/管理者 記事詳細画面
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/show/{id}")
	public String showArticle(HttpSession session,Model model,
			@PathVariable int id) {
		
		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
	
		ArticleDataDto article = articleService.findArticleData(id);
		
		model.addAttribute("article", article);
		
		return "article/showArticle";
	}

}
