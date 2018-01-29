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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SlashController {
	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String Controller(Model model) {

		int page = 0;
		int size = 5;

		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new Sort.Order(Sort.Direction.ASC, "xmmc"));

		Pageable pageable = new PageRequest(page, size, sort);

		try {
			model.addAttribute("slash", new ObjectMapper().writeValueAsString(bzxmRepository.findAll(pageable)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "slash";
	}
}
