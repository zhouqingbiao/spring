package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Bzxm;
import com.application.entity.BzxmRepository;

@RestController
public class Controller {
	@Autowired
	private BzxmRepository bzxmRepository;

	@RequestMapping(value = "/")
	public Page<Bzxm> restController() {

		int page = 0;
		int size = 5;
		Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "xzqh"), new Sort.Order(Sort.Direction.ASC, "xmmc"));

		Pageable pageable = new PageRequest(page, size, sort);

		return bzxmRepository.findAll(pageable);
	}
}
