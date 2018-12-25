package kr.ac.computereng.labmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public ModelAndView sayhello() {
		return new ModelAndView("hello", "model", "test");
	}
}
