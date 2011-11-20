package com.iwebproject.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld() {
		logger.info("helloWorld() method begin...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloWorld");
		mav.addObject("message", "Hello World!");
		
		logger.info("helloWorld() method end...");
		
		return mav;
	}
}
