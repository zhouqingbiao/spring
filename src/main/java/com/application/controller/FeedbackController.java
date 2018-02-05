package com.application.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

		MimeMessage mm = jms.createMimeMessage();

		if (email == null && feedback == null) {

		} else if (StringUtils.isEmpty(email)) {
			model.addAttribute("email", "写下您的电子邮件！");
		} else if (StringUtils.isEmpty(feedback)) {
			model.addAttribute("feedback", "写下您的反馈和建议！");
		} else {

			try {
				MimeMessageHelper mmh = new MimeMessageHelper(mm, true);

				// 主题
				mmh.setSubject(email);

				mmh.setText(feedback);

				// 发件人
				String from = "zhouqingbiao@qq.com";
				mmh.setFrom(from);

				// 收件人
				String[] to = { "zhouqingbiao@qq.com", "zhouqingbiaozhou@gmail.com" };
				mmh.setTo(to);

				jms.send(mm);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		return "feedback";
	}
}
