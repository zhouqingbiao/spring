package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OracleController {

	@RequestMapping(value = "/oracle", method = { RequestMethod.GET })
	public String oracleController(Model model, String html) {

		html = null == html ? "oracle" : html;

		return html;
	}
}
