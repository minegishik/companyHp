package com.company.hp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginContoller {

	/**
	 * ログイン初期ページ(管理者のみにこのURLを周知する)
	 * @return
	 */
	@GetMapping("index")
	public String index(Model model, HttpSession session) {

		return "login/index";
	}
	
	
	/**
	 *ログイン成功時初期ページ 
	 * @return
	 */
	@PostMapping("admin")
	public String top(Model model, HttpSession session) {
		
		return "home/index";
	}

}
