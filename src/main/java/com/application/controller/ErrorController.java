package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Error;
import com.application.entity.ErrorRepository;

@RestController
public class ErrorController {

	@Autowired
	private ErrorRepository errorRepository;

	@RequestMapping("/")
	public Error getError() {
		return errorRepository.findOne(15);
	}
}
