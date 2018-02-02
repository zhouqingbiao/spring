package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeedbackController {
	@Autowired
	private JavaMailSender jms;

	@RequestMapping(value = "/feedback", method = { RequestMethod.GET, RequestMethod.POST })
	public String feedbackController(Model model, String email, String feedback) {

		SimpleMailMessage smm = new SimpleMailMessage();

		if (StringUtils.isEmpty(email)) {
			model.addAttribute("email", "写下您的电子邮件！");
		} else if (StringUtils.isEmpty(feedback)) {
			model.addAttribute("feedback", "写下您的反馈和建议！");
		} else {
			smm.setSubject(email);
			smm.setText(feedback);

			String from = "zhouqingbiao@qq.com";
			smm.setFrom(from);

			String[] to = { "zhouqingbiao@qq.com", "zhouqingbiaozhou@gmail.com" };
			smm.setTo(to);

			jms.send(smm);
		}

		return "feedback";
	}
}
