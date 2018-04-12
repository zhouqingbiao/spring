package com.application.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MiscellaneousController {

	@RequestMapping(value = "/miscellaneous", method = { RequestMethod.GET })
	public String miscellaneousController(Model model, String html) {

		html = StringUtils.isEmpty(html) ? "miscellaneous" : html;

		return html;
	}
}
