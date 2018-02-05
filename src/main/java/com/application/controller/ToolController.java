package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToolController {

	@RequestMapping(value = "/tool", method = { RequestMethod.GET })
	public String toolController(Model model, String html) {

		html = StringUtils.isEmpty(html) ? "tool" : html;

		return html;
	}
}
