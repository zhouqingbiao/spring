package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.Error;
import com.application.entity.ErrorRepository;

@RestController
public class ErrorController {

	@Autowired
	private ErrorRepository jstZfbzDataErrorRepository;

	@RequestMapping("/")
	public Error getError() {
		Error jstZfbzDataError = new Error();
		jstZfbzDataError = jstZfbzDataErrorRepository.findOne(15);
		return jstZfbzDataError;
	}
}
