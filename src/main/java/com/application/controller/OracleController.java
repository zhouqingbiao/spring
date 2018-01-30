package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OracleController {

	@RequestMapping(value = "/oracle", method = { RequestMethod.GET })
	public String bzxmController(Model model, Integer page) {
		page = null == page ? 0 : page;

		String oracle = "oracle";

		switch (page) {
		case 1:
			oracle = "oracle/html/ssbkj";
			break;

		default:
			break;
		}

		return oracle;
	}
}
