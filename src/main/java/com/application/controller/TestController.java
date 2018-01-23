package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.entity.ErrorRepository;

@Controller
public class TestController {
	@Autowired
	private ErrorRepository errorRepository;

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getError(Model model) {
		model.addAttribute("error", errorRepository.findAll());
		return "error";
	}

	@RequestMapping(value = "/ip")
	public String getip() {
		return "ip";
	}
}
