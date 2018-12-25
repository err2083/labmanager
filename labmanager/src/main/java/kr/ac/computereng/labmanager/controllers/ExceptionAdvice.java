package kr.ac.computereng.labmanager.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);
		
		return modelAndView;
	}
}
