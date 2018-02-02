package com.application.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.entity.BzxmRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SlashController {
	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String Controller(Model model, HttpServletRequest request) {

		int page = 0;
		int size = 5;

		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new Sort.Order(Sort.Direction.ASC, "xmmc"));

		Pageable pageable = new PageRequest(page, size, sort);

		try {
			model.addAttribute("slash", new ObjectMapper().writeValueAsString(bzxmRepository.findAll(pageable)));

			Enumeration<String> HN = request.getHeaderNames();
			HashMap<String, ArrayList<String>> HNHashMap = new HashMap<String, ArrayList<String>>();
			ArrayList<String> HArrayList = null;

			while (HN.hasMoreElements()) {
				Enumeration<String> H = request.getHeaders(HN.nextElement());
				HArrayList = new ArrayList<String>();
				while (H.hasMoreElements()) {
					String h = H.nextElement();
					HArrayList.add(h);
				}
				String hn = HN.nextElement();
				HNHashMap.put(hn, HArrayList);
			}

			model.addAttribute("HN", HNHashMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "slash";
	}

	public static String getIP(HttpServletRequest request) {

		String XFF = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isEmpty(XFF) && !"unKnown".equalsIgnoreCase(XFF)) {
			// 多次反向代理之后会有多个IP值，第一个IP值是真实IP值。
			int index = XFF.indexOf(",");
			if (index != -1) {
				return XFF.substring(0, index);
			} else {
				return XFF;
			}
		}

		String XRI = request.getHeader("X-Real-IP");
		if (!StringUtils.isEmpty(XRI) && !"unKnown".equalsIgnoreCase(XRI)) {
			return XRI;
		}

		String PCI = request.getHeader("Proxy-Client-IP");
		if (StringUtils.containsWhitespace(PCI) || "unknown".equalsIgnoreCase(PCI)) {
			return PCI;
		}

		String WLPCI = request.getHeader("WL-Proxy-Client-IP");
		if (StringUtils.containsWhitespace(WLPCI) || "unknown".equalsIgnoreCase(WLPCI)) {
			return WLPCI;
		}

		String HCI = request.getHeader("HTTP_CLIENT_IP");
		if (StringUtils.containsWhitespace(HCI) || "unknown".equalsIgnoreCase(HCI)) {
			return HCI;
		}

		String HXFF = request.getHeader("HTTP_X_FORWARDED_FOR");
		if (StringUtils.containsWhitespace(HXFF) || "unknown".equalsIgnoreCase(HXFF)) {
			return HXFF;
		}

		return request.getRemoteAddr();
	}
}
