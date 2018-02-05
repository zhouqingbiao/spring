package com.application.controller.others;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value = "/page", method = { RequestMethod.GET, RequestMethod.POST })
	public String pageController(Model model, Integer page, String email, String password) {

		if (null == email && password == null) {

		} else if (email.equals("") || password.equals("")) {
			if (email.equals("")) {
				model.addAttribute("email", "Email cannot be empty.");
			}
			if (password.equals("")) {
				model.addAttribute("password", "Password cannot be empty.");
			}
			return "index";
		} else if (email.equals("zhouqingbiao@qq.com") && password.equals("zhouqingbiao")) {

		} else {
			model.addAttribute("danger", "Incorrect username or password.");
			return "index";
		}

		// page = null == page ? 0 : page;
		// int size = 5;
		// Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new
		// Sort.Order(Sort.Direction.ASC, "xmmc"));

		// Pageable pageable = new PageRequest(page, size, sort);
		// model.addAttribute("page", bzxmRepository.findAll(pageable));

		return "page";
	}
}
