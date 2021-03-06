package com.application.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SlashController {

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String controller(Model model, HttpServletRequest request) {

		// IP
		model.addAttribute("RA", request.getRemoteAddr());

		return "slash";
	}
}
