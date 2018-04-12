package com.application.web.others;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String indexController(Model model) {

		return "index";
	}
}
