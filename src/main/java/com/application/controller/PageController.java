package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.entity.BzxmRepository;

@Controller
public class PageController {

	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/page", method = { RequestMethod.GET, RequestMethod.POST })
	public String pageController(Model model, Integer page, String email, String password) {

		if (null == email && password == null) {

		} else if (email.equals("") || password.equals("")) {
			return "index";
		} else if (email.equals("zhouqingbiao@qq.com") && password.equals("zhouqingbiao")) {

		} else {
			return "index";
		}

		page = null == page ? 0 : page;
		int size = 5;
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new Sort.Order(Sort.Direction.ASC, "xmmc"));

		Pageable pageable = new PageRequest(page, size, sort);
		model.addAttribute("page", bzxmRepository.findAll(pageable));

		return "page";
	}
}
