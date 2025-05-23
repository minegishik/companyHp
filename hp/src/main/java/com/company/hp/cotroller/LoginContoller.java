package com.company.hp.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.hp.dto.ArticleDataDto;
import com.company.hp.entity.AdminData;
import com.company.hp.form.LoginForm;
import com.company.hp.service.ArticleService;
import com.company.hp.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginContoller {

	@Autowired
	LoginService loginService;
	@Autowired
	ArticleService articleService;

	/**
	 * ログイン初期ページ(管理者のみにこのURLを周知する)
	 * @return
	 */
	@GetMapping("/index")
	public String index(@ModelAttribute("form") LoginForm form, Model model, HttpSession session) {

		model.addAttribute("form", form);

		return "login/index";
	}

	/**
	 *ログインボタン押下 
	 * @return
	 */
	@PostMapping("/admin")
	public String top(@ModelAttribute("form") LoginForm form, Model model, HttpSession session) {

		AdminData loginUser = loginService.findLoginUser(form.getEmail(), form.getPassword());

		//管理者情報があればセッションに情報をセットする・なければリセット
		if (loginUser != null && loginUser.getEmail().equals(form.getEmail()) &&
				loginUser.getPassword().equals(form.getPassword())) {

			session.setAttribute("loginUser", loginUser);
			List<ArticleDataDto> articleList = articleService.getArticle(1,0);
			
			model.addAttribute("articleList",articleList);

			return "home/index";
		} else if(form.getEmail() == null || form.getPassword() == null){
			return "login/index";
			
		}

		return "login/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate(); // セッション無効化
	    return "redirect:/";
	}
	
}


