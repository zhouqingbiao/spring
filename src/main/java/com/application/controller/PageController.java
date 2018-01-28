package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.entity.BzxmRepository;

@Controller
public class PageController {

	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/page")
	public String pageController(Model model, Integer page) {

		page = null == page ? 0 : page;
		int size = 5;
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new Sort.Order(Sort.Direction.ASC, "xmmc"));

		Pageable pageable = new PageRequest(page, size, sort);
		model.addAttribute("page", bzxmRepository.findAll(pageable));

		return "page";
	}
}
