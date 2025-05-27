package com.company.hp.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.hp.dto.ArticleDataDto;
import com.company.hp.entity.AdminData;
import com.company.hp.form.ArticleForm;
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
	public String list(HttpSession session, Model model) {

		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);

		//ログイン状況で取得データを分岐する
		if (loginUser == null) {

			List<ArticleDataDto> articleList = articleService.getArticle(1, 0);
			model.addAttribute("articleList", articleList);

		} else if (loginUser != null) {

			List<ArticleDataDto> adminArticleList = articleService.getAllArticle();
			model.addAttribute("adminArticleList", adminArticleList);

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
	public String showArticle(HttpSession session, Model model,
			@PathVariable int id) {

		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);

		ArticleDataDto article = articleService.findArticleData(id);

		model.addAttribute("article", article);

		return "article/show";
	}
	

	/**
	 * 記事編集画面 初期画面
	 * @param session
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/edit/{id}")
	public String editArticle(HttpSession session, Model model,
			@PathVariable int id) {

		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);

		ArticleDataDto article = articleService.findArticleData(id);

		model.addAttribute("article", article);

		return "article/edit";
	}
	
	
	/**
	 * 記事編集更新ボタン押下
	 * @param form
	 * @param articleId
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping("/update/{id}")
	public String updateArticle(@ModelAttribute ArticleForm form,
			@PathVariable int id, HttpSession session, Model model) {
		
		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		
		ArticleDataDto article = articleService.findArticleData(id);

		model.addAttribute("article", article);

		articleService.editArticle(form, id);
		
		return "redirect:/article/edit/" + id;
	}
	
	
	
	
	
	/**
	 * 記事削除ボタン押下 記事一覧画面へリダイレクト
	 * @param session
	 * @param model
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	public String deleteArticle(HttpSession session, Model model,
			@PathVariable int id) {
		
		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		
		 //削除実行
		articleService.deleteArticle(id);
		
		return "redirect:/article/list";
	}

}
