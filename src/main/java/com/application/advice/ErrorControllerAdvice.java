package com.application.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorControllerAdvice {

	@ExceptionHandler
	public ModelAndView handlerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);

		ModelAndView ModelAndView = new ModelAndView();

		ModelAndView.addObject("status", status);

		ModelAndView.setViewName("error");

		return ModelAndView;
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}