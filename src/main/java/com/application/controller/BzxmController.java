package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.entity.BzxmRepository;

@Controller
public class BzxmController {

	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/bzxm", method = RequestMethod.GET)
	public String getError(Model model) {
		model.addAttribute("bzxm", bzxmRepository.findAll());
		return "bzxm";
	}
}
