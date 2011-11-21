package com.iwebproject.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iwebproject.bean.User;
import com.iwebproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;

    @RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User loginUser,ModelMap modelMap ){
        logger.info("login() method begin...");

        User user = this.userService.read(loginUser);

        logger.info("login() method end...");

        ModelAndView mav;
        
        if(null != user){
            mav = new ModelAndView("redirect:/user/index");  
        }else{
            modelMap.put("errorTips", "用户名或密码错误！");
            mav = new ModelAndView("/index", modelMap);
        }
        
        return mav;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user) {
		logger.info("register() method begin...");
		
		this.userService.create(user);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("helloWorld");
		mav.addObject("message", "Hello World!");
		
		logger.info("register() method end...");
		
		return mav;
	}

    @RequestMapping(value="/index")
	public ModelAndView index(){
        logger.info("index() method end...");
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("helloWorld");
        mav.addObject("message", "Hello World!");
        
        logger.info("index() method end...");
        
        return mav;
	}
}
