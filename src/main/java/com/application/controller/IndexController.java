package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jws.Jws;
import com.jws.JwsService;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index(Model model) {
		JwsService service = new JwsService();
		Jws jws = service.getJwsPort();
		// keys模糊查询关键字
		String arg0 = "*濮家新村*";

		// index
		// 0-->HZ_GIS.TPS_FW
		// 1-->HZ_FWDJ.TPF_JCDJB
		// 2-->HZ_GIS.TPS_ZRZ
		int arg1 = 0;

		// rows返回数据条数
		int arg2 = 30;

		// model.addAttribute("index", jws.getData(arg0, arg1, arg2));

		return "index";
	}
}
