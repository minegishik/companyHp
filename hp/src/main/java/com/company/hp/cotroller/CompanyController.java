package com.company.hp.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	/**
	 * 会社概要画面
	 * @param model
	 * @return
	 */
	@GetMapping("/profile")
	public String profile(Model model) {
		
		return "other/companyProfile";
	}
	
	

}
