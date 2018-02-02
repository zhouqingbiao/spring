package com.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jws.Jws;
import com.jws.JwsService;

@Controller
public class IndexController {
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String indexController(Model model) {

		JwsService service = new JwsService();
		Jws jws = service.getJwsPort();

		//
		System.out.println("JwsService.getJwsPort().hashCode()" + jws.hashCode());

		// keys模糊查询关键字
		String arg0 = "*濮家新村*";

		// index
		// 0-->HZ_GIS.TPS_FW
		// 1-->HZ_FWDJ.TPF_JCDJB
		// 2-->HZ_GIS.TPS_ZRZ
		int arg1 = 0;

		// rows返回数据条数
		int arg2 = 1;

		long start = System.nanoTime();
		model.addAttribute("index", jws.getData(arg0, arg1, arg2));
		long end = System.nanoTime();

		System.out.println((end - start) + "纳秒");
		System.out.println((end - start) / 1000000 + "毫秒");
		System.out.println((end - start) / 1000000000 + "秒");

		model.addAttribute("arg0", arg0);
		model.addAttribute("arg1", arg1);
		model.addAttribute("arg2", arg2);

		return "index";
	}
}
