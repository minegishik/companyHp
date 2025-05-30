package com.company.hp.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.hp.dto.ArticleDataDto;
import com.company.hp.entity.AdminData;
import com.company.hp.service.ArticleService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 *企業HP 初期ページ 
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
		AdminData loginUser = (AdminData) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		
		List<ArticleDataDto> articleList = articleService.getArticle(1,0);
		
		model.addAttribute("articleList",articleList);
		
		return "home/index";
	}

}
